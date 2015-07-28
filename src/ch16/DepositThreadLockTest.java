package ch16;

/**
 * Created by YouZeng on 2015-07-27.
 */
class DrawAmountThreadLockTest extends Thread{
    private AccountLock AccountLock;
    private double drawAmount;

    public DrawAmountThreadLockTest(String name, AccountLock AccountLock, double drawAmount) {
        super(name);
        this.AccountLock = AccountLock;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        for(int i = 0;i < 100;i ++){
            AccountLock.drawAmount(drawAmount);
        }
    }
}
public class DepositThreadLockTest extends Thread {
    private AccountLock AccountLock;
    private double depositAmount;

    public DepositThreadLockTest(String name, AccountLock AccountLock, double depositAmount) {
        super(name);
        this.AccountLock = AccountLock;
        this.depositAmount = depositAmount;
    }

    @Override
    public void run() {
        for(int i = 0;i < 100;i ++){
            AccountLock.deposit(depositAmount);
        }
    }

    public static void main(String[] args) {
        AccountLock acct = new AccountLock("chen", 0);
        new DrawAmountThreadLockTest("取款者甲", acct, 800).start();
        new DrawAmountThreadLockTest("取款者乙", acct, 800).start();
        new DepositThreadLockTest("存款者甲", acct, 800).start();
        new DepositThreadLockTest("存款者乙", acct, 800).start();
        new DepositThreadLockTest("存款者丙", acct, 800).start();
    }
}
