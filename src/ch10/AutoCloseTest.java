package ch10;

import java.io.*;

/**
 * Created by YouZeng on 2015-05-21.
 * JDK1.7 try里面的类实现了AutoCloseable或者Closeable会自动回收资源
 */
public class AutoCloseTest {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new FileReader("AutoCloseTest.class"));
            PrintStream ps = new PrintStream(new FileOutputStream("a.txt"))
        ){
            //使用2个资源
            System.out.println(br.readLine());
            ps.println("庄生晓梦迷蝴蝶");
        }
    }
}
