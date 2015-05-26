package ch13;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by YouZeng on 2015-05-22.
 */
public class CallableStatementTest {
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

    public void callProcedure() throws SQLException {
        try(Connection connection = DriverManager.getConnection(url, username, password);
            CallableStatement statement = connection.prepareCall("{call add_pro(?, ?, ?)}")
        ){
            statement.setInt(1, 4);
            statement.setInt(2, 5);
            statement.registerOutParameter(3, Types.INTEGER);
            statement.execute();
            System.out.println("执行存储过程的结果为：" + statement.getInt(3));
        }
    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        CallableStatementTest ed = new CallableStatementTest();
        ed.initParam("mysql.ini");
        ed.callProcedure();
    }
}
