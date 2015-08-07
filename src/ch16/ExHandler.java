package ch16;

/**
 * Created by YouZeng on 2015-08-07.
 */
public class ExHandler {
    public static void main(String[] args) {
        Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t + "线程触发了异常" + e);
            }
        });
        int a = 3 / 0;
        System.out.println("a的值为：" + a);
    }
}
