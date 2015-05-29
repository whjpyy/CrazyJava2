package ch13;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by YouZeng on 2015-05-28.
 */
public class CacheRowSetPageTest {
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

    public CachedRowSet getCacheRowSet(String sql, int pageSize, int page) throws SQLException {
        RowSetFactory factory = RowSetProvider.newFactory();
        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
        ){
            CachedRowSet cacheRs = factory.createCachedRowSet();
            cacheRs.setPageSize(pageSize);
            cacheRs.populate(rs, (page - 1) * pageSize + 1);
            return cacheRs;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        CacheRowSetPageTest test = new CacheRowSetPageTest();
        test.initParam("mysql.ini");
        CachedRowSet cacheRs = test.getCacheRowSet("select * from student_table" ,10, 3);
        cacheRs.afterLast();
        while(cacheRs.previous()){
            System.out.println(cacheRs.getString(1) + "\t" +
                    cacheRs.getString(2) + "\t" +cacheRs.getString(3));
        }
    }
}
