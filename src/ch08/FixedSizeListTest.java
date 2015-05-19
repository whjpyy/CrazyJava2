package ch08;


import java.util.Arrays;
import java.util.List;

/**
 * Created by YouZeng on 2015-05-19.
 */
public class FixedSizeListTest {
    public static void main(String[] args) {
        List list = Arrays.asList("c", "a", "b");
        System.out.println(list);
        list.add("d");  //不能修改
    }
}
