package ch15;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by YouZeng on 2015-06-10.
 */
public class FileLockTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        try(FileChannel channel = new FileOutputStream("out.txt").getChannel()){
            FileLock lock = channel.tryLock();
            Thread.sleep(10000);
            lock.release();
        }
    }
}
