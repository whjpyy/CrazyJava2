package ch16;

/**
 * Created by YouZeng on 2015-06-12.
 */
public class StartDeadTest extends Thread {
    @Override
    public void run() {
        for(int i = 0;i < 100;i += 1){
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        StartDeadTest test = new StartDeadTest();
        for(int i = 0;i < 300;i += 1){
            System.out.println(Thread.currentThread().getName() + " " + i);
            if(i == 20){
                test.start();
                System.out.println("线程是否存活：" + test.isAlive());
            }
            if(i > 20 && !test.isAlive()){
                test.start();
            }
        }
    }
}
