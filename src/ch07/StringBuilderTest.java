package ch07;

/**
 * Created by YouZeng on 2015-05-18.
 */
public class StringBuilderTest {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println(sb.append("World"));
        System.out.println(sb.insert(5, " "));
        System.out.println(sb.replace(5, 6, ","));
        System.out.println(sb.delete(5, 6));
        System.out.println(sb.reverse());
        System.out.println(sb.length());
        System.out.println(sb.capacity());
        sb.setLength(5);
        System.out.println(sb);
    }
}
