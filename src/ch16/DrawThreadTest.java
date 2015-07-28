package ch16;

/**
 * Created by YouZeng on 2015-07-27.
 */
public class DrawThreadTest extends Thread {
    private Account account;
    private double drawAmount;

    public DrawThreadTest(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        for(int i = 0;i < 100;i ++){
            account.drawMoney(drawAmount);
        }
    }

    public static void main(String[] args) {
        //创建一个账户
        Account acct = new Account("chen", 0);
        new DrawThreadTest("取款者甲", acct, 800).start();
        new DepositThreadTest("存款者甲", acct, 800).start();
        new DepositThreadTest("存款者乙", acct, 800).start();
        new DepositThreadTest("存款者丙", acct, 800).start();
    }
}
