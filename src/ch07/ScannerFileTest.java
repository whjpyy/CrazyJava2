package ch07;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * 读取本地Java源文件
 * Created by YouZeng on 2015-05-08.
 */
public class ScannerFileTest {
    public static void main(String[] args) throws IOException {
        File file = new File(System.getProperty("user.dir") + "/CrazyJava2/src/ch07/ScannerFileTest.java");
        Scanner scanner = new Scanner(file);
        System.out.println("****************文件内容****************");
        while(scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
        System.out.println("****************文件内容****************");
    }
}
