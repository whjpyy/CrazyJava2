package ch15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by YouZeng on 2015-06-08.
 */
public class FileChannelTest{

    public static void main(String[] args) throws IOException {
        File file = new File("CrazyJava2/src/ch15/FileChannelTest.java");
        try(FileChannel inChannel = new FileInputStream(file).getChannel();
            FileChannel outChannel = new FileOutputStream("out.txt").getChannel()
        ){
            //将inChannel全部映射为buffer
            MappedByteBuffer mbb = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            outChannel.write(mbb);
            //再次调用buffer的clear方法
            mbb.clear();
            //获取字符串
            Charset charset = Charset.forName("UTF-8");
            CharsetDecoder decoder = charset.newDecoder();
            CharBuffer buffer = decoder.decode(mbb);
            System.out.println(buffer);
        }
    }
}
