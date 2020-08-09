package dao;

import exception.OrderSystemException;
import modal.DBUtil;
import modal.Dish;
import modal.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 1.新增订单(顾客)
// 2.查找所有订单（商家）
// 3.查看指定用户订单（顾客）
// 4.查看指定订单的详情信息
// 5.修改订单状态（商家）


public class OrderDao {
    // 1.新增订单-- 和两个表相关联
    // 第一个表 order_user
    // 第二个表 order_dish
    public void add(Order order) throws OrderSystemException {
        // 1.order_user 表插入
        addOrderUser(order);
        // 2.order_dish 表插入
        //     order 中 orderId 是不知道的，是由数据库自主生成的
        //     可以在上个方法中获取到 id 插入到 orderId 中
        addOrderDish(order);
        // 如果第一个表插入订单成功，第二个表失败，整体就不算插入成功
        // 1.可以通过 事务来解决
        // 2.也可以在第二次执行失败时将 addOrderUser 中此次执行插入的记录删掉
    }

    private void addOrderUser(Order order) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into order_user values(null, ?,now(), 0)";
            // 在预编译的后，通过 PreparedStatement.RETURN_GENERATED_KEYS 可以获取到自增主键的值
            statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, order.getUserId());
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("新增订单失败");
            }
            // 把自增主键的值给读取出来
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                // 理解参数1
                // 由于一个表中的自增列可以有多个，返回的时候都返回来了
                // 1 表示获取到第一个自增列生成的值
                order.setOrderId(resultSet.getInt(1));
            }
            System.out.println("新增订单成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("新增订单失败");
        }finally {
            DBUtil.getClose(connection, statement, null);
        }
    }

    private void addOrderDish(Order order) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into Order_dish values(?, ?)";
            // 关闭自动提交 sql  (一般默认是自动提交的)
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            // 由于一个订单中有多个菜品,所有得把数组中的菜品一个个取出来插入表中
            List<Dish> dishes = order.getDishes();
            for (Dish dish: dishes) {
                statement.setInt(1, order.getOrderId());
                statement.setInt(2, dish.getDishId());
                //  给 sql 的 values 新增一个片段
                statement.addBatch();
            }
            statement.executeBatch();  // 执行刚才的 sql 语句，提交 sql
            connection.commit(); // 真正执行 sql，即发送给服务器
        } catch (SQLException e) {
            e.printStackTrace();
            // 如果此表插订单失败，整体上插入就失败了，回滚之间的 addOrderUser 表的内容
            deleteOrderUser(order.getOrderId());
        }finally {
            DBUtil.getClose(connection, statement, null);
        }
    }

    // 用来删除 order_user 表中的数据
    private void deleteOrderUser(int orderId) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "delete from order_user where orderId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("回滚失败");
            }
            System.out.println("回滚成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("回滚失败");
        }finally {
            DBUtil.getClose(connection, statement, null);
        }
    }

    // 2.查找所有订单（商家）
    // order 对象里除最后一个参数，其他的可根据 order_user 表中获取
    // list<Dish> 菜品详情就需要根据 order_dish 表，获取到 dishId 取 dish 表中获取菜品信息
    // 此方法中不包含 菜品详情
    public List<Order> selectAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Order> orders = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from order_user";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                // order 中没有 dishes 字段
                Order order = new Order();
                order.setOrderId(resultSet.getInt("orderId"));
                order.setUserId(resultSet.getInt("userId"));
                order.setTime(resultSet.getTimestamp("time"));
                order.setIsDone(resultSet.getInt("isDone"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.getClose(connection, statement, resultSet);
        }
        return orders;
    }

    // 3.查看指定用户订单（顾客）
    public List<Order> selectByUserId(int userId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Order> orders = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from order_user where userId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                // order 中没有 dishes 字段
                Order order = new Order();
                order.setOrderId(resultSet.getInt("orderId"));
                order.setUserId(resultSet.getInt("userId"));
                order.setTime(resultSet.getTimestamp("time"));
                order.setIsDone(resultSet.getInt("isDone"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.getClose(connection, statement, resultSet);
        }
        return orders;
    }

    // 4.查看指定订单的详情信息
    // 除此之外。还可以使用多表查询的方法实现
    public Order selectById(int orderId) {
        // 1.先根据 orderId 得到一个 order 对象 --- order_user 表
        Order order = buildOrder(orderId);
        // 2,根据 orderId 得到该 orderId 对应的菜品 id 的列表 -- order_dish 表
        List<Integer> dishIds = selectDishIds(orderId);
        // 3.根据菜品 id 列表查询菜品信息  -- dish 表
        order = getDishDetail(order, dishIds);
        return order;
    }

    private Order buildOrder(int orderId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from order_user where orderId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,orderId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt("orderId"));
                order.setUserId(resultSet.getInt("userId"));
                order.setTime(resultSet.getTimestamp("time"));
                order.setIsDone(resultSet.getInt("isDone"));
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.getClose(connection, statement, resultSet);
        }
        return null;
    }

    private List<Integer> selectDishIds(int orderId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Integer> dishIds = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from order_dish where orderId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,orderId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                dishIds.add(resultSet.getInt("dishId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.getClose(connection, statement, resultSet);
        }
        return dishIds;
    }

    private Order getDishDetail(Order order, List<Integer> dishIds) {
        List<Dish> dishes = new ArrayList<>();
        // 根据 dishId 在 dishes 表中查找
        DishDao dishDao = new DishDao();
        for (Integer dishId: dishIds) {
            Dish dish = dishDao.selectById(dishId);
            dishes.add(dish);
        }
        order.setDishes(dishes);
        return order;
    }

    // 5.修改订单状态
    public void changeState(int orderId, int isDone) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "update order_user set isDone = ? where orderId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, isDone);
            statement.setInt(2, orderId);
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("修改订单状态失败");
            }
            System.out.println("修改订单状态成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("修改订单状态失败");
        }finally {
            DBUtil.getClose(connection, statement, null);
        }
    }

    public static void main(String[] args) throws OrderSystemException {
        OrderDao orderDao = new OrderDao();
        Order order = new Order();
        order.setUserId(1);
        List<Dish> list = new ArrayList<>();
        DishDao dishDao = new DishDao();
        list.add(dishDao.selectById(1));
        list.add(dishDao.selectById(2));
        order.setDishes(list);
        System.out.println(list);
        orderDao.add(order);
    }
}
