package ch09;

/**
 * Created by YouZeng on 2015-05-20.
 */
public class ErasureTest {
    public static void main(String[] args) {
        Apple<Integer> apple = new Apple<>(6);
        Integer i = apple.getInfo();
        System.out.println(i.getClass());
        Apple b = apple;
        Object o = b.getInfo();
        System.out.println(o.getClass());
    }
}
