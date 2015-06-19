package ch16;

/**
 * Created by YouZeng on 2015-06-15.
 */
public class DaemonThreadTest extends Thread{
    @Override
    public void run() {
        for(int i = 0;i < 1000;i += 1){
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        DaemonThreadTest test = new DaemonThreadTest();
        test.setDaemon(true);
        test.start();
        for(int i = 0;i < 100;i += 1){
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
