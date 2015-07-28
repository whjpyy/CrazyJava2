package ch16;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Procuder extends Thread{
    private BlockingQueue queue;

    public Procuder(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String[] arr = new String[]{"Chen", "You", "Zeng"};
        for(int i = 0;i < 10;i ++){
            System.out.println(getName() + "开始生产集合元素");
            try{
                Thread.sleep(200);
                queue.put(arr[i % 3]);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "生产完成：" + queue);
        }
    }
}

class Customer extends Thread{
    private BlockingQueue queue;

    public Customer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            System.out.println(getName() + "消费者开始消费结集合元素！");
            try {
                Thread.sleep(200);
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "消费完成：" + queue);
        }
    }
}

/**
 * Created by YouZeng on 2015-07-28.
 */
public class BlockingQueueTest2 {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(1);
        //启动3个生产者线程
        new Procuder(queue).start();
        new Procuder(queue).start();
        new Procuder(queue).start();
        //启动1个消费者线程
        new Customer(queue).start();
    }
}
