package ch15;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by YouZeng on 2015-06-03.
 */
public class FileReaderTest {

    public static void main(String[] args) throws IOException {

        try(//创建字符输入流
            Reader reader = new FileReader("CrazyJava2/src/ch15/FileReaderTest.java")
        ) {
            //创建木桶
            char[] chars = new char[1];
            int hasRead = 0;
            while ((hasRead = reader.read(chars)) > 0) {
                System.out.print(new String(chars, 0, hasRead));
            }
        }
        /*System.out.println("中".getBytes().length);
        System.out.println("中".getBytes("GBK").length);
        System.out.println("中".getBytes("unicode").length);*/
    }
}
