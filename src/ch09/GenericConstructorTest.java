package ch09;

/**
 * Created by YouZeng on 2015-05-20.
 */
public class GenericConstructorTest {
    public <T> GenericConstructorTest(T t){
        System.out.println(t);
    }

    public static void main(String[] args) {
        new GenericConstructorTest("字符串");
        new GenericConstructorTest(1);
        new <String> GenericConstructorTest("字符串");
    }
}
