package ch15;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by YouZeng on 2015-06-08.
 */
public class AppendContentTest {

    public static void main(String[] args) throws IOException {
        try(RandomAccessFile raf = new RandomAccessFile("out.txt", "rw")){
            raf.seek(raf.length());
            raf.write("追加的内容\r\n".getBytes());
        }
    }
}
