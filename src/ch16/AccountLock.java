package ch16;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by YouZeng on 2015-06-19.
 */
public class AccountLock {
    //定义锁对象
    private final ReentrantLock lock = new ReentrantLock();
    //获取指定Lock对象对应的Condition
    private final Condition condition = lock.newCondition();
    private String accountNo;
    private double balance;
    //标识账户中是否已有存款的标识
    private boolean flag = false;
    public AccountLock(String accountNo, double balance) {
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

    public void draw(double drawAmount){
        lock.lock();
        if (balance >= drawAmount) {
            System.out.println(Thread.currentThread().getName() + "取钱成功！吐出钞票：" + drawAmount);
            balance -= drawAmount;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\t余额：" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + "取钱失败！余额不足。");
        }
        lock.unlock();
    }

    public void drawAmount(double drawAmount){
        lock.lock();
        try{
            if(!flag){
                condition.await();
            }else{
                System.out.println(Thread.currentThread().getName() + " 取钱：" + drawAmount);
                balance -= drawAmount;
                System.out.println("账户余额为：" + balance);
                flag = false;
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void deposit(double depositAmount){
        lock.lock();
        try{
            if(flag){
                condition.await();
            }else {
                System.out.println(Thread.currentThread().getName() + " 存钱：" + depositAmount);
                balance += depositAmount;
                System.out.println("账户余额为：" + balance);
                flag = true;
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj != null && obj instanceof AccountLock){
            AccountLock target = (AccountLock)obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }
}
