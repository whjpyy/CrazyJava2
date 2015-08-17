package ch16;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by YouZeng on 2015-08-07.
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        executorService.submit(new MyThread("线程1"));
        executorService.submit(new MyThread("线程2"));
        executorService.shutdown();
    }
}
