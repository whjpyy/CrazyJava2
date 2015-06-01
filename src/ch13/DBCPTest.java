package ch13;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by YouZeng on 2015-06-01
 * Apache的数据库连接池实现：DBCP
 */
public class DBCPTest {
    private static final String BASE_DIR = System.getProperty("user.dir") + "/CrazyJava2/src/";
    BasicDataSource ds;
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

        ds = new BasicDataSource();
        //设置连接池所需的驱动
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        //设置初始连接数为15
        ds.setInitialSize(15);
        //设置最多可有20个活动连接数
        ds.setMaxActive(20);
        //设置最少有2个空闲连接
        ds.setMinIdle(2);
    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        DBCPTest test = new DBCPTest();
        test.initParam("mysql.ini");

        try(Connection conn = test.ds.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select * from select_test.jdbc_test");
            ResultSet rs = stmt.executeQuery()
        ){
            while(rs.next()){
                System.out.println(rs.getString(1) + "\t" + rs.getString(2));
            }
        }
    }
}
