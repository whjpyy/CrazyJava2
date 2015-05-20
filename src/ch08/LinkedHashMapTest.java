package ch08;

import java.util.LinkedHashMap;

/**
 * Created by YouZeng on 2015-05-20.
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap map = new LinkedHashMap();
        map.put("语文", 84);
        map.put("数学", 88);
        map.put("英语", 81);
        for(Object key : map.keySet() ){
            System.out.println(key + ", " + map.get(key));
        }
    }
}
