package ch15;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by YouZeng on 2015-06-08.
 */
public class ChannelReadTest {

    public static void main(String[] args) throws IOException {
        try(FileInputStream fis = new FileInputStream("transient.txt");
            FileChannel fileChannel = fis.getChannel()
        ){
            //定义一个buffer
            ByteBuffer buffer = ByteBuffer.allocate(4);
            while( fileChannel.read(buffer) != -1 ){
                buffer.flip();
                Charset charset = Charset.defaultCharset();
                CharBuffer cb = charset.decode(buffer);
                System.out.println(cb);
                buffer.clear();
            }
        }
    }
}
