package ch09;

/**
 * Created by YouZeng on 2015-05-20.
 */
public class Apple<T> {
    private T info;
    public Apple(T t){
        this.info = t;
    }
    public T getInfo() {
        return info;
    }
    public void setInfo(T info) {
        this.info = info;
    }

    public static void main(String[] args) {
        Apple<String> str = new Apple<>("字符串");
        System.out.println(str.getInfo());

        Apple<Integer> i = new Apple<>(12);
        System.out.println(i.getInfo());

        System.out.println(str.getClass() + ", " + i.getClass());
    }
}

class A1 extends Apple{

    public A1(Object o) {
        super(o);
    }
}

class A2 extends Apple<String>{

    public A2(String s) {
        super(s);
    }
}