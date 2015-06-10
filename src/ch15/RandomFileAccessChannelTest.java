package ch15;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by YouZeng on 2015-06-08.
 */
public class RandomFileAccessChannelTest {

    public static void main(String[] args) throws IOException {
        File f = new File("out.txt");
        try(RandomAccessFile raf = new RandomAccessFile(f, "rw");
            FileChannel randomChannel = raf.getChannel()
        ){
            MappedByteBuffer mbb = randomChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
            randomChannel.position(f.length());
            randomChannel.write(mbb);
        }
    }
}
