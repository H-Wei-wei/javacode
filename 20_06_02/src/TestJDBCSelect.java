import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TestJDBCSelect {
    public static void main(String[] args) throws SQLException {
        // 1、创建一个 DataSource 对象
        DataSource dataSource = new MysqlDataSource();
        // 配置 DataSource
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/20_06_02?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1212");

        // 2、创建 Connection 对象，并数据库建立连接
        Connection connection = dataSource.getConnection();

        // 3、拼装 SQL 语句，用 preparedStatement 来实现
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);

        // 4、执行 SQL 语句, 用  executeQuery
        ResultSet resultSet = statement.executeQuery();

        // 5、遍历结果集，遍历过程和使用迭代器有点像
        while (resultSet.next()) {
            // resultSet 指向当前行
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int classId = resultSet.getInt("classId");
            System.out.println(id +" "+ name + " " + classId);
        }

        // 6、关闭释放相关资源
        resultSet.close();
        statement.close();
        connection.close();

    }
}
