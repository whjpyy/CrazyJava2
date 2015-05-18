package ch07;

import java.util.Calendar;
import static java.util.Calendar.*;

/**
 * Created by YouZeng on 2015-05-18.
 */
public class CalendarTest {

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(YEAR) + "-" + (c.get(MONTH) + 1) + "-" + c.get(DAY_OF_MONTH));
        //set 延时设置
        c.set(2003, 7, 31);
        c.set(MONTH, 8);
        System.out.println(c.getTime());
        c.set(DATE, 5);
        System.out.println(c.getTime());

    }
}
