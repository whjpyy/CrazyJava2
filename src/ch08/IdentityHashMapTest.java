package ch08;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * Created by YouZeng on 2015-05-20.
 */
public class IdentityHashMapTest {
    public static void main(String[] args) {
        Map map1 = new IdentityHashMap();
        map1.put(new String("a"), "1");
        map1.put(new String("a"), "2");
        map1.put("b", 1);
        map1.put("b", 2);
        System.out.println(map1);

        Map map2 = new HashMap();
        map2.put(new String("a"), "1");
        map2.put(new String("a"), "2");
        map2.put("b", 1);
        map2.put("b", 2);
        System.out.println(map2);
    }
}
