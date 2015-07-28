package ch16;

/**
 * Created by YouZeng on 2015-06-19.
 */
public class Account {
    private String accountNo;
    private double balance;

    //标识账户中是否已有存款的旗标
    private boolean flag = false;

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public synchronized void draw(double drawAmount){
        if (balance >= drawAmount) {
            System.out.println(Thread.currentThread().getName() + "取钱成功！吐出钞票：" + drawAmount);
            balance -= drawAmount;
            System.out.println("\t余额：" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + "取钱失败！余额不足。");
        }
    }

    public synchronized void drawMoney(double drawAmount){
        try {
            //如果flag为假，表名账户中还没有人存钱进去，取钱方法阻塞
            if(!flag){
                wait();
            }else{
                //执行取钱操作
                System.out.println(Thread.currentThread().getName() + " 取钱：" + drawAmount);
                balance -= drawAmount;
                System.out.println("账户余额为：" + balance);
                flag = false;
                //唤醒其他线程
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void deposit(double depositAmount){
        try {
            if(flag){
                wait();
            }else{
                //执行存款操作
                System.out.println(Thread.currentThread().getName() + " 存款：" + depositAmount);
                balance += depositAmount;
                System.out.println("账户余额为：" + balance);
                flag = true;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj != null && obj instanceof Account){
            Account target = (Account)obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }
}
