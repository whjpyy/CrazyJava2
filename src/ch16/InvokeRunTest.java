package ch16;

/**
 * Created by YouZeng on 2015-06-12.
 */
public class InvokeRunTest extends Thread {

    @Override
    public void run() {
        for(int i = 0;i < 100;i += 1){
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for(int i = 0;i < 100;i += 1){
            System.out.println(Thread.currentThread().getName() + " " + i);
            if(i == 20){
                new InvokeRunTest().run();
                new InvokeRunTest().run();
            }
        }
    }
}
