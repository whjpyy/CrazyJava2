package ch15;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by YouZeng on 2015-06-03.
 */
public class PrintStreamTest {

    public static void main(String[] args) throws IOException {
        try(FileOutputStream fos = new FileOutputStream("newFile.txt");
            PrintStream ps = new PrintStream(fos);
        ){
            ps.println("普通字符串");
            ps.println(new PrintStreamTest());
        }
    }
}
