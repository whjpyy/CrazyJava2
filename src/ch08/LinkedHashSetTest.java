package ch08;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by YouZeng on 2015-05-19.
 */
public class LinkedHashSetTest {
    public static void main(String[] args) {
        Set set = new LinkedHashSet();
        set.add("a");
        set.add("b");
        set.add("c");
        System.out.println(set);
        set.remove("a");
        set.add("a");
        System.out.println(set);

    }
}
