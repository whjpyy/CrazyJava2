package ch15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by YouZeng on 2015-06-04.
 */
public class KeyinTest {

    public static void main(String[] args) throws IOException {
        InputStreamReader fsr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(fsr);

        String buffer;
        while( (buffer = br.readLine()) != null ){
            if("exit".equals(buffer)){
                break;
            }
            System.out.println("输入的内容为：" + buffer);
        }
    }
}
