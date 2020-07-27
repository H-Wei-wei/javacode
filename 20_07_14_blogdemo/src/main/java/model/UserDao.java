package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    // 新增用户
    public void addUser(User user) {
        // 1.建立连接
        Connection connection = DBUtil.getConnection();
        // 2.拼装 SQL 语句
        String sql = "insert into user values (null, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            // 3.执行 SQL 语句
            int ret = statement.executeUpdate();
            if (ret != 1) {
                System.out.println("新增用户失败");
                return;
            }
            System.out.println("新增用户成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭连接
            DBUtil.close(connection, statement, null);
        }
    }

    // 查找用户(登录)
    public User selectByName(String name) {
        // 1.建立连接
        Connection connection = DBUtil.getConnection();
        // 2.拼装 SQL 语句
        String sql = "select * from user where name = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            // 3.执行 SQL
            resultSet = statement.executeQuery();
            // 4.遍历结果集
            // 此处查找最多查找一条记录
            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5.关闭连接
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }

    // 根据用户id找到用户信息
    public User selectById(int userId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from user where userId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

//    public static void main(String[] args) {
//        UserDao userDao = new UserDao();
//       // 1.测试增加用户
////        User user = new User();
////        user.setName("ww");
////        user.setPassword("1212");
////        userDao.addUser(user);
//        // 2.测试查看用户
////        User user = userDao.selectByName("ww");
////        System.out.println(user);
//    }
}
