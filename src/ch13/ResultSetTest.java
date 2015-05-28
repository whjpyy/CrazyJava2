package ch13;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by YouZeng on 2015-05-22.
 */
public class ResultSetTest {
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

    public void query(String sql) throws SQLException {
        try(Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet set = statement.executeQuery()
        ){
            set.last();
            int rowCount = set.getRow();
            for (int i = rowCount; i > 0; i--) {
                set.absolute(i);
                System.out.println(set.getString(1) + "\t" + set.getString(2) + "\t" + set.getString(3));
                set.updateString(2, "学生_" + set.getString(2));
                set.updateRow();
            }
        }
    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        ResultSetTest ed = new ResultSetTest();
        ed.initParam("mysql.ini");
        ed.query("select * from jdbc_test");
    }
}
