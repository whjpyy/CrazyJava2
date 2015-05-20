package ch08;

import java.util.*;

/**
 * Created by YouZeng on 2015-05-20.
 */
public class UnModifiableTest {
    public static void main(String[] args) {
        List list = Collections.emptyList();
        list.add("a");
        Set set = Collections.singleton("b");
        set.add("c");
        Map map = new HashMap();
        map.put("a", 1);
        map.put("b", 2);
        Map unmodifiableMap = Collections.unmodifiableMap(map);
        unmodifiableMap.put("c", 3);
    }
}
