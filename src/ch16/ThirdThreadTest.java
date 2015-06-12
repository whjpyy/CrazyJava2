package ch16;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by YouZeng on 2015-06-12.
 */
public class ThirdThreadTest implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int i = 0;
        for(;i < 10000;i += 1){
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }

    public static void main(String[] args) {
        ThirdThreadTest thread = new ThirdThreadTest();
        FutureTask<Integer> task = new FutureTask<Integer>(thread);
        for(int i = 0;i < 100;i += 1){
            System.out.println(Thread.currentThread().getName() + " " + i);
            if(i == 20){
                new Thread(task, "有返回值的线程1").start();
                new Thread(task, "有返回值的线程2").start();
            }
        }
        try {
            System.out.println("子线程的返回值：" + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
