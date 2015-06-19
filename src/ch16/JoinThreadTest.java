package ch16;

/**
 * Created by YouZeng on 2015-06-15.
 */
public class JoinThreadTest extends Thread{
    public JoinThreadTest(String name){
        super(name);
    }

    @Override
    public void run() {
        for(int i = 0;i < 100;i += 1){
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new JoinThreadTest("线程1").start();
        for(int i = 0;i < 100;i += 1){
            if(i == 20){
                JoinThreadTest test = new JoinThreadTest("被调用的线程");
                test.start();
                test.join();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
