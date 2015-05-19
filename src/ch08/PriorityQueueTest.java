package ch08;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by YouZeng on 2015-05-19.
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        Queue queue = new PriorityQueue();
        queue.offer(2);
        queue.offer(-2);
        queue.offer(7);
        queue.offer(3);
        System.out.println(queue);
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            System.out.print(queue.poll() + " ");
        }
    }
}
