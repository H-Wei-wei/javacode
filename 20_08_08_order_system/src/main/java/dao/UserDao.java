package dao;

import assist.OrderSystemException;
import modal.DBUtil;
import modal.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    // 1.插入数据
    // 2.根据 name 查找用户
    // 3.根据 userId查找用户

    public void addUser(User user) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            String sql = "insert into user values(null, ?, ?, ?)";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getIsAdmin());
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("插入用户失败");
            }
            System.out.println("插入用户成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("插入用户失败");
        }finally {
            DBUtil.getClose(connection, statement, null);
        }
    }

    public User selectByName(String name) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from user where name = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setIsAdmin(resultSet.getInt("isAdmin"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("查找失败");
        }finally {
            DBUtil.getClose(connection, statement,resultSet);
        }
        return user;
    }

    public User selectById(int userId) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from user where userId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setIsAdmin(resultSet.getInt("isAdmin"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("查找失败");
        }finally {
            DBUtil.getClose(connection, statement,resultSet);
        }
        return user;
    }

    public static void main(String[] args) throws OrderSystemException {
//        UserDao userDao = new UserDao();
//        User user = new User();
//        user.setName("微微");
//        user.setPassword("2222");
//        user.setIsAdmin(0);
//        userDao.addUser(user);
//
//        System.out.println(userDao.selectByName("WeiWei"));
//        System.out.println(userDao.selectById(2));
    }
}
