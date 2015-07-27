package ch16;

/**
 * Created by YouZeng on 2015-06-19.
 */
public class DrawThread extends Thread{
    private Account account;
    private double drawAmount;

    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        if(account.getBalance() >= drawAmount){
            System.out.println(getName() + "取钱成功！吐出钞票：" + drawAmount);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.setBalance(account.getBalance() - drawAmount);
            System.out.println("\t余额：" + account.getBalance());
        }else{
            System.out.println("余额不足，取钱失败！");
        }
    }

    public static void main(String[] args) {
        Account account = new Account("账号", 1000);
        new DrawThread("甲", account, 800).start();
        new DrawThread("乙", account, 800).start();
    }
}
