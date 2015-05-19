package ch07;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by YouZeng on 2015-05-19.
 */
public class NumberFormatTest {
    public static void main(String[] args) {
        double d = 1234000.567;
        Locale[] locales = {Locale.CHINA, Locale.JAPAN, Locale.GERMAN, Locale.US};
        NumberFormat[] nfs = new NumberFormat[12];
        for (int i = 0; i < locales.length; i++) {
            nfs[i * 3] = NumberFormat.getNumberInstance(locales[i]);
            nfs[i * 3 + 1] = NumberFormat.getPercentInstance(locales[i]);
            nfs[i * 3 + 2] = NumberFormat.getCurrencyInstance(locales[i]);
        }
        for (int i = 0; i < locales.length; i++) {
            switch (i){
                case 0:
                    System.out.println("-------中国的格式-------");
                    break;
                case 1:
                    System.out.println("-------日本的格式-------");
                    break;
                case 2:
                    System.out.println("-------德国的格式-------");
                    break;
                case 3:
                    System.out.println("-------美国的格式-------");
                    break;
            }
            System.out.println("通用数值格式：" + nfs[i * 3].format(d));
            System.out.println("百分比数值格式：" + nfs[i * 3 + 1].format(d));
            System.out.println("货币数值格式：" + nfs[i * 3 + 2].format(d));
        }
    }
}
