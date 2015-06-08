package ch15;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by YouZeng on 2015-06-08.
 */
public class RandomFileAccessTest {

    private static String fileBase = "CrazyJava2/src/ch15/";

    public static void main(String[] args) throws IOException {
        try(RandomAccessFile raf = new RandomAccessFile(fileBase + "RandomFileAccessTest.java", "r")){
            System.out.println("随机访问文件的初始位置为：" + raf.getFilePointer());
            raf.seek(300);
            byte[] bytes = new byte[1024];
            int hasRead = 0;
            while( (hasRead = raf.read(bytes)) > 0 ){
                System.out.print(new String(bytes, 0, hasRead));
            }
        }
    }
}
