package ch14;

import java.lang.reflect.Method;

/**
 * Created by YouZeng on 2015-06-02.
 */
public class RunTest {
    public static void process(String clazz) throws ClassNotFoundException {
        int passed = 0;
        int failed = 0;
        for(Method m : Class.forName(clazz).getMethods()){
            if(m.isAnnotationPresent(Testable.class)){
                try{
                    m.invoke(null);
                    passed++;
                }catch (Exception e){
                    System.out.println("方法" + m + "运行失败，异常：" + e.getCause());
                    failed++;
                }
            }
        }
        System.out.println("共运行了" + (passed + failed) + "个方法，其中成功了" + passed + "个，失败了" + failed + "个");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("----------测试TestClassOne----------");
        RunTest.process("ch14.TestClassOne");
        System.out.println("----------测试TestClassTwo----------");
        RunTest.process("ch14.TestClassTwo");
    }
}

class TestClassOne{
    @Testable
    public static void m1(){}
    public static void m2(){}
    @Testable
    public static void m3(){
        throw new RuntimeException("BOOM");
    }
    public static void m4(){}
    @Testable
    public static void m5(){}
    public static void m6(){}
    @Testable
    public static void m7(){
        throw new RuntimeException("Crash");
    }
    public static void m8(){}
}

class TestClassTwo{
    @Testable
    public static void m1(){}
    @Testable
    public static void m2(){
        throw new RuntimeException("fuck you");
    }
    @Testable
    public static void m3(){
        throw new RuntimeException("BOOM");
    }
    public static void m4(){}
    @Testable
    public static void m5(){}
    public static void m6(){}
    @Testable
    public static void m7(){
        throw new RuntimeException("Crash");
    }
    public static void m8(){}
}