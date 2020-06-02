import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBCDelete {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入要删除的学生姓名");
        String name = sc.next();

        // 1、先创建一个 DataSource 对象
        DataSource dataSource = new MysqlDataSource();
        // 配置
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/20_06_02?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1212");

        // 2、建立连接
        Connection connection = dataSource.getConnection();

        // 3、拼装 SQL
        String sql = "delete from student where name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);

        // 4、 执行 SQL
        int ret = statement.executeUpdate();
        if (ret == 1) {
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }

        // 5、关闭资源
        statement.close();
        connection.close();
    }
}
