package ch08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by YouZeng on 2015-05-20.
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties p = new Properties();
        p.setProperty("username", "chen");
        p.setProperty("password", "123");
        p.setProperty("hello", "你好");
        p.store(new FileOutputStream("ini.ini"), "用户信息");
        p.storeToXML(new FileOutputStream("xml.xml"), "用户信息");

        Properties p2 = new Properties();
        p2.setProperty("gender", "male");
        p2.load(new FileInputStream(new File("ini.ini")));
        System.out.println(p2);

        Properties p3 = new Properties();
        p3.loadFromXML(new FileInputStream("xml.xml"));
        System.out.println(p3);
    }
}
