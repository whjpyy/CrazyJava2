package ch07;

import java.util.Objects;

/**
 * Created by YouZeng on 2015-05-18.
 * JDK1.7 新增Objects类
 */
public class ObjectsTest {

    public static void main(String[] args) {
        Object obj = null;
        System.out.println(Objects.hashCode(obj));
        System.out.println(Objects.toString(obj));
        System.out.println(Objects.requireNonNull(obj, "obj不能为nulll"));

    }
}
