package ch10;

/**
 * Created by YouZeng on 2015-05-21.
 * JDK1.7 支持多异常处理.
 */
public class MutilException {
    public static void main(String[] args) {
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = a / b;
            System.out.println("结果" + c);
        }catch (ArrayIndexOutOfBoundsException|NumberFormatException|ArithmeticException e){
            System.out.println("程序发生数组越界，数字格式异常，算法异常之一");
            //多异常捕获时e被final所修饰
        }catch (Exception e){
            System.out.println("未知异常");
            //单异常捕获时e没有被final修饰
        }
    }
}
