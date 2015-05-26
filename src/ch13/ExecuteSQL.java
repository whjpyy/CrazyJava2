package ch13;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by YouZeng on 2015-05-22.
 */
public class ExecuteSQL {
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

    public void executeSQL(String sql) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        try(Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement()
        ) {
            boolean hasResult = stmt.execute(sql);
            if(hasResult){
                try(ResultSet set = stmt.getResultSet()){
                    ResultSetMetaData metaData = set.getMetaData();
                    int columnNumber = metaData.getColumnCount();
                    while(set.next()){
                        for (int i = 0; i < columnNumber; i++) {
                            System.out.print(set.getString(i + 1) + "\t");
                        }
                        System.out.println();
                    }
                }
            }else{
                System.out.println("--系统中共有" + stmt.getUpdateCount() + "条数据受影响--");
            }
        }
    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        ExecuteSQL ed = new ExecuteSQL();
        ed.initParam("mysql.ini");
        //执行删除表的DDL语句
        ed.executeSQL("drop table if exists my_test");
        //执行建表的DDL语句
        ed.executeSQL("create table my_test(test_id int auto_increment primary key," +
                "test_name varchar(255))");
        //执行插入数据的DML语句
        ed.executeSQL("insert into my_test(test_name) select student_name from student_table");
        //执行查询数据的查询语句
        ed.executeSQL("select * from my_test");
    }
}
