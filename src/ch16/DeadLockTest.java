package ch16;

public class DeadLockTest extends Thread{

    public boolean flag = true;
    static final Object a = new Object();
    static final Object b = new Object();

    @Override
    public void run() {
        if(flag){
            while(true){
                synchronized (a){
                    System.out.println(Thread.currentThread().getName() + ", a。。。");
                    synchronized (b){
                        System.out.println(Thread.currentThread().getName() + ", a > b。。。");
                    }
                }
            }
        }else{
            while(true){
                synchronized (b){
                    System.out.println(Thread.currentThread().getName() + ", b。。。");
                    synchronized (a){
                        System.out.println(Thread.currentThread().getName() + ", b > a。。。");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLockTest t1 = new DeadLockTest();
        DeadLockTest t2 = new DeadLockTest();
        t1.start();
        t2.flag = false;
        t2.start();
    }
}
