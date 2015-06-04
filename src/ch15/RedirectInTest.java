package ch15;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by YouZeng on 2015-06-04.
 */
public class RedirectInTest {

    public static void main(String[] args) throws IOException {
        try(FileInputStream fis = new FileInputStream("CrazyJava2/src/ch15/RedirectInTest.java")){
            System.setIn(fis);

            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");
            while(scanner.hasNext()){
                System.out.println("输入的内容是：" + scanner.next());
            }
        }
    }
}
