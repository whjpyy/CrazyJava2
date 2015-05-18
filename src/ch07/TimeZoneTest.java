package ch07;

import java.util.Arrays;
import java.util.TimeZone;

/**
 * Created by YouZeng on 2015-05-18.
 */
public class TimeZoneTest {
    public static void main(String[] args) {
        //获取Java所支持的所有时区ID
        String[] ids = TimeZone.getAvailableIDs();
        System.out.println(Arrays.toString(ids));
        TimeZone my = TimeZone.getDefault();
        System.out.println(my.getID());
        System.out.println(my.getDisplayName());
        System.out.println(TimeZone.getTimeZone("CNT").getDisplayName());
    }
}
