package ch15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by YouZeng on 2015-06-05.
 */
public class ReadFromProcessTest {

    public static void main(String[] args) throws IOException {
        Process p = Runtime.getRuntime().exec("javac");
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream(), "GBK"));

        String str = "";
        while( (str = br.readLine()) != null ){
            System.out.println(str);
        }
    }
}
