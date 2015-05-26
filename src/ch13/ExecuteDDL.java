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
public class ExecuteDDL {
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

    public int insertData(String sql) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        try(Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement()
        ) {
            return stmt.executeUpdate(sql);
        }
    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        ExecuteDDL ed = new ExecuteDDL();
        ed.initParam("mysql.ini");
        int result = ed.insertData("insert into jdbc_test(jdbc_name,jdbc_desc) "
            + " select s.student_name,t.teacher_name from student_table s, teacher_table t"
            + " where s.java_teacher = t.teacher_id");
        System.out.println("--系统中公有" + result + "条数据受影响--");
    }
}
