package ch16;

/**
 * Created by YouZeng on 2015-08-07.
 */
class MyThread extends Thread{
    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        for(int i = 0;i < 20;i ++){
            System.out.println(getName() + "线程i的值为：" + i);
        }
    }
}

public class ThreadGroupTest {
    public static void main(String[] args) {
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println("主线程组的名字：" + mainGroup.getName() + ",主线程组是否为后台线程组："  + mainGroup.isDaemon());
        new MyThread("主线程组的线程A").start();

        ThreadGroup myGroup = new ThreadGroup("我的线程组");
        myGroup.setDaemon(true);
        new MyThread(myGroup, "我的线程组中的线程甲").start();
        new MyThread(myGroup, "我的线程组中的线程乙").start();
    }
}
