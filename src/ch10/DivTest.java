package ch10;

/**
 * Created by YouZeng on 2015-05-21.
 */
public class DivTest {
    public static void main(String[] args) {
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = a / b;
            System.out.println("结果" + c);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("数组越界");
        }catch (NumberFormatException e){
            System.out.println("数字转换异常");
        }catch (ArithmeticException e){
            System.out.println("算术异常");
        }catch (Exception e){
            System.out.println("未知异常");
        }
    }
}
