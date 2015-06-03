package ch15;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by YouZeng on 2015-06-03.
 */
public class FileInputStreamTest {

    public static void main(String[] args) throws IOException {
        //创建字节输入流
        FileInputStream fis = new FileInputStream("CrazyJava2/src/ch15/FileInputStreamTest.java");

        byte[] bytes = new byte[40];
        int hasRead = 0;
        while( (hasRead = fis.read(bytes)) > 0 ){
            System.out.print(new String(bytes, 0, hasRead));
        }

        fis.close();
    }
}
