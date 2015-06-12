package ch16;

/**
 * Created by YouZeng on 2015-06-12.
 */
public class FirstThreadTest extends Thread{

    private int i;

    @Override
    public void run() {
        for(;i < 100;i += 1){
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0;i < 100;i += 1){
            System.out.println(Thread.currentThread().getName() + " " + i);
            if(i == 20){
                //不共享线程类的实例属性
                new FirstThreadTest().start();
                new FirstThreadTest().start();
            }
        }
    }
}
