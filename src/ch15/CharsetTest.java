package ch15;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created by YouZeng on 2015-06-10.
 */
public class CharsetTest {

    public static void main(String[] args) {
        Map<String, Charset> charsetMap = Charset.availableCharsets();
        for(String key : charsetMap.keySet()){
            System.out.println(key + ", " + charsetMap.get(key));
        }

        //本地的编辑字符集
        System.out.println("本地字符集：" + System.getProperty("file.encoding"));
    }
}
