package ch08;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by YouZeng on 2015-05-19.
 */
public class HashSetTest {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(new A());
        set.add(new A());
        set.add(new B());
        set.add(new B());
        set.add(new C());
        set.add(new C());
        System.out.println(set);
    }
}

class A{
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
class B{
    @Override
    public int hashCode() {
        return 1;
    }
}
class C{
    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        return 2;
    }
}
