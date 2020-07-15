package model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//管理数据库
// 1、建立连接
// 2、断开连接
// JDBC 中使用 DataSource 来管理连接
// DBUtil 相当于是对 DataSource 再包装一层
// dataSource 每个应用程序只应该有一个实例，即单例模式
// DBUtil  本质上就是实现了一个单例模式，管理唯一的一个 DataSource 实例
// 单例模式----饿汉模式、懒汉模式
public class DBUtil {
    private static volatile DataSource dataSource = null;
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/java_blogdemo?characterEncoding=utf-8&useSSL=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1212";

    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (DBUtil.class) {
                if (dataSource == null) {
                    dataSource = new MysqlDataSource();
                    // 给 dataSource 设置一些属性
                    ((MysqlDataSource)dataSource).setURL(URL);
                    ((MysqlDataSource)dataSource).setUser(USERNAME);
                    ((MysqlDataSource)dataSource).setPassword(PASSWORD);
                }
            }
        }
        return dataSource;
    }

    // 建立连接
    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 断开连接
    public static void close(Connection connection, PreparedStatement Statement,
                              ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (Statement != null) {
                Statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
