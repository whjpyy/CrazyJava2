package ch08;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by YouZeng on 2015-05-19.
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        set.add(5);
        set.add(-3);
        set.add(4);
        set.add(9);
        System.out.println(set);
        System.out.println(set.first());
        System.out.println(set.last());
        System.out.println(set.headSet(4));
        System.out.println(set.tailSet(4));
        System.out.println(set.subSet(-1, 5));

        set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                M m1 = (M)o1;
                M m2 = (M)o2;
                return m1.age - m2.age;
            }
        });
        set.add(new M(23));
        set.add(new M(4));
        set.add(new M(52));
        set.add(new M(25));
        System.out.println(set);
    }
}

class M{
    int age;
    public M(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "M[age=" + age + "]";
    }
}
