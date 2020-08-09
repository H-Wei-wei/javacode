package dao;

// 1.增加菜品
// 2.删除菜品
// 3.查询所有菜品
// 4.查寻指定菜品

import exception.OrderSystemException;
import modal.DBUtil;
import modal.Dish;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishDao {

    // 1.增加菜品
    public void addDish(Dish dish) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into dishes value(null, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, dish.getName());
            statement.setInt(2, dish.getPrice());
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("增加菜品失败");
            }
            System.out.println("增加菜品成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("增加菜品失败");
        }finally {
            DBUtil.getClose(connection, statement, null);
        }
    }

    // 2.删除菜品
    public void deleteById(int dishId) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "delete from dishes where dishId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, dishId);
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("删除菜品失败");
            }
            System.out.println("删除菜品成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("删除菜品失败");
        }finally {
            DBUtil.getClose(connection, statement, null);
        }
    }

    // 3.查询所有菜品
    public List<Dish> selectAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Dish> dishes = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from dishes";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Dish dish = new Dish();
                dish.setDishId(resultSet.getInt("dishId"));
                dish.setName(resultSet.getString("name"));
                dish.setPrice(resultSet.getInt("price"));
                dishes.add(dish);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.getClose(connection, statement, resultSet);
        }
        return dishes;
    }

    // 4.查寻指定菜品
    public Dish selectById(int dishId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from dishes where dishId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,dishId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Dish dish = new Dish();
                dish.setDishId(resultSet.getInt("dishId"));
                dish.setName(resultSet.getString("name"));
                dish.setPrice(resultSet.getInt("price"));
                return dish;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.getClose(connection, statement, resultSet);
        }
        return null;
    }

    public static void main(String[] args) throws OrderSystemException {
        DishDao dishDao = new DishDao();
//        Dish dish = new Dish();
//        dish.setName("鱼香肉丝");
//        dish.setPrice(18);
//        dishDao.addDish(dish);

//        List<Dish> dishes = dishDao.selectAll();
//        System.out.println(dishes);
//
//        System.out.println(dishDao.selectById(2));
//        dishDao.deleteById(3);
    }
}
