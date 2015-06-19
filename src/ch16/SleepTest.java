package ch16;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by YouZeng on 2015-06-15.
 */
public class SleepTest {

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0;i < 10;i ++){
            System.out.println(new SimpleDateFormat("hh:mm:ss").format(new Date()));
            Thread.sleep(1000);
        }
    }
}
