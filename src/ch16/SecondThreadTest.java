package ch16;

/**
 * Created by YouZeng on 2015-06-12.
 */
public class SecondThreadTest implements Runnable{

    private int i;

    @Override
    public void run() {
        for(;i < 100;i += 1){
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0;i < 100;i += 1){
            System.out.println(Thread.currentThread().getName() + " " + i);
            if(i == 20){
                SecondThreadTest secondThread = new SecondThreadTest();
                //共享线程类的实例属性
                new Thread(secondThread, "新线程1").start();
                new Thread(secondThread, "新线程2").start();
            }
        }
    }
}
