package ch16;

/**
 * Created by YouZeng on 2015-06-19.
 */
public class DrawSyncBlockThread extends Thread{
    private Account account;
    private double drawAmount;

    public DrawSyncBlockThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        synchronized (account) {
            if (account.getBalance() >= drawAmount) {
                System.out.println(getName() + "取钱成功！吐出钞票：" + drawAmount);
                account.setBalance(account.getBalance() - drawAmount);
                System.out.println("\t余额：" + account.getBalance());
            } else {
                System.out.println(getName() + "取钱失败！余额不足。");
            }
        }
    }

    public static void main(String[] args) {
        Account account = new Account("账号", 1000);
        new DrawSyncBlockThread("甲", account, 800).start();
        new DrawSyncBlockThread("乙", account, 800).start();
    }
}
