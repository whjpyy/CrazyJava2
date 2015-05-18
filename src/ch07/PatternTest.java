package ch07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by YouZeng on 2015-05-18.
 */
public class PatternTest {
    public static void main(String[] args) {
        Matcher m = Pattern.compile("\\w+").matcher("Java is so easy");
        while(m.find()){
            System.out.println(m.group() + "，起始位置：" + m.start() + ", 终止位置：" + m.end());
        }
        int i = 0;
        while(m.find(i)){
            System.out.print(i + ": " + m.group() + ",");
            i += 1;
        }
        //matches
        System.out.println();
        String[] mails = {"409121@qq.com", "1@b.cn", "www.baidu.com"};
        String mailReg = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
        Matcher matcher = null;
        for(String mail : mails){
            if(matcher == null){
                matcher = Pattern.compile(mailReg).matcher(mail);
            }else{
                matcher.reset(mail);
            }
            System.out.println(mail + (matcher.matches() ? "是" : "不是") + "一个有效的邮箱地址！");
        }
    }
}
