package ch16;

/**
 * Created by YouZeng on 2015-06-19.
 */
public class DrawLockThread extends Thread {

    private AccountLock account;
    private double drawAmount;

    public DrawLockThread(String name, AccountLock account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        account.draw(drawAmount);
    }

    public static void main(String[] args) {
        AccountLock account = new AccountLock("账号", 1000);
        new DrawLockThread("甲", account, 800).start();
        new DrawLockThread("乙", account, 800).start();
    }
}
