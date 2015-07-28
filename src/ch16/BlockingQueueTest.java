package ch16;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by YouZeng on 2015-07-28.
 */
public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(2);
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
    }
}
