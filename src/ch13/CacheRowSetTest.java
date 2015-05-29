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
public class CacheRowSetTest {
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

    public CachedRowSet getCacheRowSet(String sql) throws SQLException {
        RowSetFactory factory = RowSetProvider.newFactory();
        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
        ){
            CachedRowSet cacheRs = factory.createCachedRowSet();
            cacheRs.populate(rs);
            return cacheRs;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        CacheRowSetTest test = new CacheRowSetTest();
        test.initParam("mysql.ini");
        CachedRowSet cacheRs = test.getCacheRowSet("select * from student_table");
        cacheRs.afterLast();
        while(cacheRs.previous()){
            System.out.println(cacheRs.getString(1) + "\t" +
                    cacheRs.getString(2) + "\t" +cacheRs.getString(3));
            if(cacheRs.getInt("student_id") == 3){
                //修改指定记录行
                cacheRs.updateString("student_name", "孙悟空3");
                cacheRs.updateRow();
            }
        }
        //重新连接数据库
        try(Connection conn = DriverManager.getConnection(test.url, test.username, test.password)){
            conn.setAutoCommit(false);
            cacheRs.acceptChanges(conn);
        }
    }
}
