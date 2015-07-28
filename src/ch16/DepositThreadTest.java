package ch16;

/**
 * Created by YouZeng on 2015-07-27.
 */
public class DepositThreadTest extends Thread {
    private Account account;
    private double depositAccount;

    public DepositThreadTest(String name, Account account, double depositAccount) {
        super(name);
        this.account = account;
        this.depositAccount = depositAccount;
    }

    @Override
    public void run() {
        for (int i = 0;i < 100;i ++){
            account.deposit(depositAccount);
        }
    }
}
