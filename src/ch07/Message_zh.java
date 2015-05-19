package ch07;

import java.text.MessageFormat;
import java.util.Date;
import java.util.ListResourceBundle;
import java.util.ResourceBundle;

/**
 * Created by YouZeng on 2015-05-19.
 */
public class Message_zh extends ListResourceBundle {

    private final static Object[][] myData= {
        {"msg", "msg=你好，{0}!今天是{1}。"}
    };

    protected Object[][] getContents() {
        return myData;
    }

    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Message");
        String msg = resourceBundle.getString("msg");
        System.out.println(MessageFormat.format(msg, "YouZeng", new Date()));
    }
}
