package ch13;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by YouZeng on 2015-05-22.
 */
public class ExecuteDML {
    private static final String BASE_DIR = System.getProperty("user.dir") + "/CrazyJava2/src/";
    private String driver;
    private String url;
    private String username;
    private String password;

    public void initParam(String fileName) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(BASE_DIR + fileName));
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }

    public void createTable(String sql) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        try(Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement()
        ) {
            System.out.println(stmt.executeUpdate(sql));
        }
    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        ExecuteDML ed = new ExecuteDML();
        ed.initParam("mysql.ini");
        ed.createTable("create table jdbc_test(jdbc_id int auto_increment primary key," +
                "jdbc_name varchar(255), jdbc_desc text);");
        System.out.println("建表成功");
    }
}
