package ch14;

/**
 * Created by YouZeng on 2015-06-01.
 */
public class DeprecatedTest {

    @Deprecated
    public void info(){
        System.out.println("该方法已过时！");
    }

    public static void main(String[] args) {
        new DeprecatedTest().info();
    }
}
