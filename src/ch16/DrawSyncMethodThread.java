package ch16;

/**
 * Created by YouZeng on 2015-06-19.
 */
public class DrawSyncMethodThread extends Thread {

    private Account account;
    private double drawAmount;

    public DrawSyncMethodThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        account.draw(drawAmount);
    }

    public static void main(String[] args) {
        Account account = new Account("账号", 1000);
        new DrawSyncMethodThread("甲", account, 800).start();
        new DrawSyncMethodThread("乙", account, 800).start();
    }
}
