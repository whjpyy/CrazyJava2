package ch13;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by YouZeng on 2015-05-22.
 */
public class PreparedStatementTest {
    private static final String BASE_DIR = System.getProperty("user.dir") + "/CrazyJava2/src/";
    private String driver;
    private String url;
    private String username;
    private String password;

    public void initParam(String fileName) throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(BASE_DIR + fileName));
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        Class.forName(driver);
    }

    public void insertUseStatement() throws SQLException {
        long start = System.currentTimeMillis();
        try(Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement()
        ){
            for (int i = 0; i < 1000; i++) {
                statement.executeUpdate("INSERT INTO student_table VALUES (NULL ,'姓名" + i + "',1)");
            }
            System.out.println("使用Statement耗时：" + (System.currentTimeMillis() - start));
        }
    }

    public void insertUsePrepared() throws SQLException {
        long start = System.currentTimeMillis();
        try(Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO student_table VALUES (NULL , ?, 1)")
        ){
            for (int i = 0; i < 1000; i++) {
                statement.setString(1, "姓名" + i);
                statement.executeUpdate();
            }
            System.out.println("使用PreparedStatement耗时：" + (System.currentTimeMillis() - start));
        }
    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        PreparedStatementTest ed = new PreparedStatementTest();
        ed.initParam("mysql.ini");
        ed.insertUseStatement();
        ed.insertUsePrepared();
    }
}
