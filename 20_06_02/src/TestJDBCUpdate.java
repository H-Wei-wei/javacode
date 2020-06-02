import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBCUpdate {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入要修改的学生id：");
        int id = sc.nextInt();
        System.out.print("输入要修改的学生姓名:");
        String name = sc.next();

        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/20_06_02?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1212");

        Connection connection = dataSource.getConnection();

        String sql = "update student set name = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setInt(2, id);

        int ret = statement.executeUpdate();
        if (ret == 1) {
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }

        statement.close();
        connection.close();
    }
}
