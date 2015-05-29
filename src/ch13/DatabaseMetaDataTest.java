package ch13;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by YouZeng on 2015-05-28.
 */
public class DatabaseMetaDataTest {
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

    public void printResultSet(ResultSet set) throws SQLException {
        //打印列名
        ResultSetMetaData metaData = set.getMetaData();
        for (int i = 0; i < metaData.getColumnCount(); i++) {
            System.out.print(metaData.getColumnName(i + 1) + "\t");
        }
        System.out.println();
        while (set.next()){
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                System.out.print(set.getString(i + 1) + "\t");
            }
            System.out.println();
        }
        set.close();
    }

    public void info() throws SQLException {
        try(Connection conn = DriverManager.getConnection(url, username, password)){
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getTableTypes();
            System.out.println("--MySQL支持的表类型--");
            printResultSet(rs);

            rs = dbmd.getTables(null, null, "%", new String[]{"table"});
            System.out.println("--当前数据库中的所有数据表--");
            printResultSet(rs);

            rs = dbmd.getColumns(null, null, "student_table", "%");
            System.out.println("--student_table表中的所有列--");
            printResultSet(rs);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        DatabaseMetaDataTest test = new DatabaseMetaDataTest();
        test.initParam("mysql.ini");
        test.info();
    }
}
