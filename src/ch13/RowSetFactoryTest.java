package ch13;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by YouZeng on 2015-05-28.
 */
public class RowSetFactoryTest {
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

    public void update(String sql) throws SQLException {
        RowSetFactory factory = RowSetProvider.newFactory();
        try(//创建JdbcRowSet对象
            JdbcRowSet jdbcRs = factory.createJdbcRowSet()
        ){
            jdbcRs.setUrl(url);
            jdbcRs.setUsername(username);
            jdbcRs.setPassword(password);
            jdbcRs.setCommand(sql);
            jdbcRs.execute();
            jdbcRs.afterLast();
            //向前滚动结果集
            while(jdbcRs.previous()){
                System.out.println(jdbcRs.getString(1) + "\t" +
                    jdbcRs.getString(2) + "\t" +jdbcRs.getString(3));
                if(jdbcRs.getInt("student_id") == 3){
                    //修改指定记录行
                    jdbcRs.updateString("student_name", "孙悟空2");
                    jdbcRs.updateRow();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        RowSetFactoryTest test = new RowSetFactoryTest();
        test.initParam("mysql.ini");
        test.update("select * from student_table");
    }
}
