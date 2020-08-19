package dao;

import entity.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    /**
     * 登录
     * 依据用户名查询，如果找不到，返回null,
     * 否则返回一个User对象（包含了用户的所有信息）
     */
    public User login(User loginUser) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from user where username = ? and password = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, loginUser.getUsername());
            statement.setString(2, loginUser.getPassword());
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setAge(resultSet.getInt("age"));
                user.setGender(resultSet.getString("gender"));
                user.setEmail(resultSet.getString("email"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement,resultSet);
        }
        return null;
    }

    /**
     * 注册
     */
    public int insertUser(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into user values (null,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getAge());
            statement.setString(4, user.getGender());
            statement.setString(5, user.getEmail());
            int ret = statement.executeUpdate(); // 运行
            if (ret == 1) {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return 0;
    }

//    public static void main(String[] args) {
//        User user = new User();
//        user.setUsername("hw");
//        user.setPassword("1212");
//        user.setAge(18);
//        user.setGender("女");
//        user.setEmail("2195792949@qq.com");
//        insertUser(user);
//    }
}
