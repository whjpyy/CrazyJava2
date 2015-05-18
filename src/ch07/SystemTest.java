package ch07;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * Created by YouZeng on 2015-05-08.
 */
public class SystemTest {
    public static void main(String[] args) throws IOException {
        //获取系统所有的环境变量
        Map<String, String> map =  System.getenv();
        for (String name : map.keySet()){
            System.out.println(name + " --> " + map.get(name));
        }
        //获取所有的系统属性
        Properties properties = System.getProperties();
        properties.store(new FileOutputStream("out/pros.txt"), "System properties");
        System.out.println(properties.getProperty("os.name"));
    }
}
