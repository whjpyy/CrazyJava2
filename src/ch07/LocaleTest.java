package ch07;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by YouZeng on 2015-05-18.
 */
public class LocaleTest {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        Locale locale1 = Locale.ENGLISH;
        ResourceBundle bundle = ResourceBundle.getBundle("message", locale);
        ResourceBundle bundle1 = ResourceBundle.getBundle("message", locale1);
        System.out.println(bundle.getString("hello"));
        System.out.println(bundle1.getString("hello"));

        String msg = bundle.getString("msg");
        System.out.println(MessageFormat.format(msg, "Chen", new Date()));
        String msg1 = bundle1.getString("msg");
        System.out.println(MessageFormat.format(msg1, "Chen", new Date()));
    }
}
