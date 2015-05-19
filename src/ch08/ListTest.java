package ch08;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YouZeng on 2015-05-19.
 */
public class ListTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("A");
        list.add("C");
        list.add("B");
        System.out.println(list);
        list.remove(new ListA());
        System.out.println(list);
        list.remove(new ListA());
        System.out.println(list);
    }
}

class  ListA{
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}