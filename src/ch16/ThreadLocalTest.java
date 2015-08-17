package ch16;

class AccountThreadLocal{
    ThreadLocal<String> name = new ThreadLocal<>();
    public AccountThreadLocal(String name) {
        this.name.set(name);
        System.out.println("--" + this.name.get());
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }
}

/**
 * Created by YouZeng on 2015-08-14.
 */
public class ThreadLocalTest extends Thread{
    private AccountThreadLocal accout;

    public ThreadLocalTest(AccountThreadLocal accout, String name) {
        super(name);
        this.accout = accout;
    }

    @Override
    public void run() {
        for(int i = 0;i < 10;i ++){
            if(i == 6){
                accout.setName(getName());
            }
            System.out.println(accout.getName() + "账号的i的值为：" + i);
        }
    }

    public static void main(String[] args) {
        AccountThreadLocal account = new AccountThreadLocal("初始名");

        new ThreadLocalTest(account, "甲线程").start();
        new ThreadLocalTest(account, "乙线程").start();
    }
}
