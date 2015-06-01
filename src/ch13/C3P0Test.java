package ch13;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by YouZeng on 2015-06-01
 * Hibernate的数据库连接池实现：C3P0
 */
public class C3P0Test {
    private static final String BASE_DIR = System.getProperty("user.dir") + "/CrazyJava2/src/";
    ComboPooledDataSource ds;
    private String driver;
    private String url;
    private String username;
    private String password;

    public void initParam(String fileName) throws IOException, ClassNotFoundException, PropertyVetoException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(BASE_DIR + fileName));
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");

        ds = new ComboPooledDataSource();
        //设置连接池所需的驱动
        ds.setDriverClass(driver);
        ds.setJdbcUrl(url);
        ds.setUser(username);
        ds.setPassword(password);
        //设置最大连接数
        ds.setMaxPoolSize(40);
        //设置最小连接数
        ds.setMinPoolSize(2);
        //设置初始连接数
        ds.setInitialPoolSize(15);
        //设置缓存中Statement的最大数
        ds.setMaxStatements(180);
    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, PropertyVetoException {
        C3P0Test test = new C3P0Test();
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
