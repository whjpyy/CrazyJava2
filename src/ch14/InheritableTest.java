package ch14;

import java.lang.annotation.*;

/**
 * Created by YouZeng on 2015-06-02.
 */
public class InheritableTest extends Base{

    public static void main(String[] args) {
        System.out.println(InheritableTest.class.isAnnotationPresent(Inheritable.class));
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@interface Inheritable{

}

@Inheritable
class Base{

}
