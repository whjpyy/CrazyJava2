package ch13;

import java.sql.*;

/**
 * Created by YouZeng on 2015-05-22.
 */
public class ConnMysqlTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        //使用了JDK1.7自动关闭资源
        try(
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/select_test", "root", "mysql");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT S.*, T.TEACHER_NAME FROM STUDENT_TABLE S, TEACHER_TABLE T WHERE S.JAVA_TEACHER = T.TEACHER_ID");
        ) {
            System.out.println("学生ID\t学生姓名\t老师ID\t老师名称\t");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "\t\t" + resultSet.getString(2) + "\t\t"
                        + resultSet.getInt(3) + "\t\t" + resultSet.getString(4));
            }
        }
    }
}
