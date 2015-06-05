package ch15;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by YouZeng on 2015-06-05.
 */
/**
 * Created by YouZeng on 2015-06-05.
 */
public class WriteToProcessTest {

    public static void main(String[] args) throws IOException {
        Process p = Runtime.getRuntime().exec("java ch15.ReadStandard");
        System.out.println(System.getProperty("java.class.path"));
        try(PrintStream ps = new PrintStream(p.getOutputStream())) {
            ps.println("普通字符串2");
            ps.println(new WriteToProcessTest());
        }
    }
}

class ReadStandard{

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("aaa");
        Scanner s = new Scanner(System.in);
        s.useDelimiter("\n");
        try(PrintStream ps = new PrintStream(new FileOutputStream("out.txt"))) {
            while (s.hasNext()) {
                ps.print("输入的字符串为：" + s.next());
            }
        }
    }
}
