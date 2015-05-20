package ch09;

import java.util.ArrayList;
import java.util.List;

/**
 * JDK1.7 泛型后面可以不用带类型
 */
public class GenericTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        for (String item : list){
            System.out.println(item);
        }
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        System.out.println(list1);
    }
}
