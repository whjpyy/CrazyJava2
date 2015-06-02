package ch14;

import java.lang.annotation.*;

/**
 * Created by YouZeng on 2015-06-02.
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
@Documented
public @interface Id{
    String column();
    String type();
    String generator();
}
