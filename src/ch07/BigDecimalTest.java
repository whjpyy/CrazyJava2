package ch07;

import java.math.BigDecimal;

/**
 * Created by YouZeng on 2015-05-18.
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        //double用与计算会发生精度丢失
        System.out.println("0.05 + 0.01 = " + (0.05 + 0.01));
        //用BigDecimal时，最好使用字符串构造函数或者valueOf方法
        System.out.println(new BigDecimal(0.1));
        System.out.println(new BigDecimal("0.1"));
        System.out.println(BigDecimal.valueOf(0.1));
        //加减乘除
        BigDecimal b1 = new BigDecimal("0.05");
        BigDecimal b2 = new BigDecimal("0.01");
        System.out.println(b1 + " + " + b2 + " = " + b1.add(b2));
        System.out.println(b1 + " - " + b2 + " = " + b1.subtract(b2));
        System.out.println(b1 + " * " + b2 + " = " + b1.multiply(b2));
        System.out.println(b1 + " / " + b2 + " = " + b1.divide(b2));
        //精度
        b1 = new BigDecimal("2");
        b2 = new BigDecimal("3");
        System.out.println(b1 + " / " + b2 + " = " + b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP));
    }
}
