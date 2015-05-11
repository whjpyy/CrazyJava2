package ch07;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 读取键盘输入内容
 * Created by YouZeng on 2015-05-07.
 */
public class ScannerKeyBoardTest {
    public static void main(String[] args) throws IOException {
/*        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
//        while(scanner.hasNext()){
//            System.out.println("你输入的字符是：" + scanner.next());
//
//        }
        while(scanner.hasNextLong()){
            System.out.println("字数：" + scanner.nextLong());
        }*/
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while( (line = bufferedReader.readLine()) != null ){
            System.out.println(line);
        }
    }
}
