package ch16;

/**
 * Created by YouZeng on 2015-06-15.
 */
public class YieldTest extends Thread {

    @Override
    public void run() {
        for(int i = 0;i < 100;i ++){
            System.out.println(getName() + " " + i);
            if(i == 20){
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        YieldTest t1 = new YieldTest();
        t1.start();
        YieldTest t2 = new YieldTest();
        t2.setPriority(Thread.MAX_PRIORITY);
        t2.start();
    }
}
