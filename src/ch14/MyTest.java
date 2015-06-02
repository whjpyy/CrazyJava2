package ch14;

import java.lang.annotation.*;

/**
 * Created by YouZeng on 2015-06-01.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@interface Testable {
}

public class MyTest{
    @Testable
    public void info(){
        System.out.println("info");
    }

    public static void main(String[] args) {
        new MyTest().info();
    }
}