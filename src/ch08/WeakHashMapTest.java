package ch08;

import java.util.WeakHashMap;

/**
 * Created by YouZeng on 2015-05-20.
 */
public class WeakHashMapTest {
    public static void main(String[] args) {
        WeakHashMap weak = new WeakHashMap();
        weak.put(new String("a"), "a1");
        weak.put(new String("b"), "b1");
        weak.put(new String("c"), "c1");
        weak.put("d", "d1");
        System.out.println(weak);
        System.gc();
        System.runFinalization();
        System.out.println(weak);
    }
}
