package ch08;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by YouZeng on 2015-05-19.
 */
public class DequeTest {
    public static void main(String[] args) {
        Deque deque = new ArrayDeque();
        //模拟栈，先进后出
        deque.offerFirst("a");
        deque.offerFirst("c");
        deque.offerFirst("b");
        System.out.println(deque.pollFirst());
        deque.offerFirst("G");
        System.out.println(deque);
    }
}
