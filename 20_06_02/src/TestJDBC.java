import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) throws SQLException {

        // 1、创建 DataSource 对象
        DataSource dataSource = new MysqlDataSource();
        // 接下来需要针对 dataSource 进行一些配置，以便后边可以正确的访问数据库服务器
        // 主要是配置第三方面信息，URL，User，PassWord，需要进行向下转型
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/20_06_02?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1212");

        // 2、 和数据库建立连接，建立连接好了以后就可以进行后续的数据数据传输了
        // 如果连接失败就会抛出一个 SQLException 异常
        // connection 对象生命周期是比较短的，每个请求创建一个新的 connection 对象
        Connection connection = dataSource.getConnection();

        // 3、拼装 SQL 语句，用到 PrepareStatement
        // 先插入数据为例
        int id = 1;
        String name = "caocao";
        int classId = 10;
        String  sql = "insert into student values(?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        // 1，2，3 表示第几个 ？
        statement.setInt(1, id);
        statement.setString(2, name);
        statement.setInt(3, classId);
        System.out.println("statement: " + statement);

        // 4、 拼装完成后，可以执行 SQL 语句
        //   inter delete update 都使用 executeUpdate 方法来执行
        //   select 使用 executeQuery 来执行
        // ret 表示此次操作修改了多少行
        int ret = statement.executeUpdate();
        System.out.println("ret = " + ret);

        // 5、执行完毕后，关闭释放相关资源
        // 后创建的先释放，先创建的后释放
        statement.close();
        connection.close();
    }
}
