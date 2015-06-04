package ch15;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

/**
 * Created by YouZeng on 2015-06-04.
 */
public class PushbackTest {
    public static void main(String[] args) throws IOException {
        try(//创建一个PushbackReader对象，制定推回缓冲区的长度为64
            PushbackReader pr = new PushbackReader(new FileReader("CrazyJava2/src/ch15/PushbackTest.java"), 64)
        ){
            char[] buf = new char[32];
            //用于保存上次读取的字符串内容
            String lastContent = "";
            int hasRead;
            //循环读取文件内容
            while( (hasRead = pr.read(buf)) > 0){
                //将读取的内容转化成字符串
                String content = new String(buf, 0, hasRead);
                int targetIndex;
                //将上次读取的字符串和本次读取的字符串拼起来
                //查看是否包含目标字符串，如果包含目标字符串
                if( (targetIndex = (lastContent + content).indexOf("new PushbackReader")) > 0 ){
                    //将本次内容和上次内容一起推回缓冲区
                    pr.unread((lastContent + content).toCharArray());
                    //指定读取前面len个字符
                    int len = targetIndex > 32 ? 32 : targetIndex;
                    pr.read(buf, 0, len);
                    //打印读取的内容
                    System.out.print(new String(buf, 0, len));
                    System.exit(0);
                }else{
                    //打印上次读取的内容
                    System.out.print(lastContent);
                    lastContent = content;
                }
            }

        }
    }
}
