package ch15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by YouZeng on 2015-06-03.
 */
public class FileOutputStreamTest {

    public static void main(String[] args) throws IOException {
        try(
            //创建字节输入流
            FileInputStream fis = new FileInputStream("CrazyJava2/src/ch15/FileOutputStreamTest.java");
            //创建字符输出流
            FileOutputStream fos = new FileOutputStream("newFile.txt")
        ) {
            byte[] bytes = new byte[32];
            int hasRead = 0;
            while ((hasRead = fis.read(bytes)) > 0) {
                //每读取一次，即写入文件输出流，读取多少，写入多少
                fos.write(bytes, 0, hasRead);
            }
        }
    }
}
