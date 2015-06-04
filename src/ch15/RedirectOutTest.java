package ch15;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by YouZeng on 2015-06-04.
 */
public class RedirectOutTest {

    public static void main(String[] args) throws FileNotFoundException {
        try(PrintStream ps = new PrintStream(new FileOutputStream("out.txt"))){
            System.setOut(ps);
            System.out.println("普通字符串");
            System.out.println(new RedirectOutTest());
        }
    }
}
