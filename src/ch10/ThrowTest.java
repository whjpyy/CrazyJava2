package ch10;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by YouZeng on 2015-05-21.
 * JDK1.7 会判断抛出的异常的实际类型
 */
public class ThrowTest {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            new FileOutputStream("a.txt");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
