package ch10;

/**
 * Created by YouZeng on 2015-05-21.
 */
public class TheadExceptionTest implements Runnable {
    @Override
    public void run() {
        firstMethod();
    }

    private void firstMethod() {
        secondMethod();
    }

    private void secondMethod() {
        int a = 1;
        int b = 0;
        System.out.println(a / b);
    }

    public static void main(String[] args) {
        new Thread(new TheadExceptionTest()).start();
    }
}
