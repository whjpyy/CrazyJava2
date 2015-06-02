package ch14;

import java.lang.annotation.*;

/**
 * Created by YouZeng on 2015-06-02.
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
@Documented
public @interface Persistent {
    String table();
}


