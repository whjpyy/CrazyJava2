package ch16;

/**
 * Created by YouZeng on 2015-06-15.
 */
public class PriorityTest extends Thread{

    public PriorityTest(String name){
        super(name);
    }

    @Override
    public void run() {
        for(int i = 0;i < 50;i ++){
            System.out.println(getName() + "的优先级是；" + this.getPriority() + ", i：" + i);
        }
    }

    public static void main(String[] args) {
        Thread.currentThread().setPriority(6);
        for(int i = 0;i < 30;i ++){
            if(i == 10){
                PriorityTest low = new PriorityTest("低级");
                low.start();
                System.out.println("low创建之时的优先级：" + low.getPriority());
                low.setPriority(Thread.MIN_PRIORITY);
            }
            if(i == 20){
                PriorityTest high = new PriorityTest("高级");
                high.start();
                System.out.println("high创建之时的优先级：" + high.getPriority());
                high.setPriority(Thread.MAX_PRIORITY);
            }
        }
    }
}
