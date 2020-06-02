import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;


public class TestJDBCSelect {
    public static void main(String[] args) {

        DataSource dataSource = new MysqlDataSource();

        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/20_06_02?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1212");



    }
}
