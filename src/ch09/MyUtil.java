package ch09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by YouZeng on 2015-05-20.
 */
public class MyUtil {

    /**
     * 通配符上限
     * @param dest
     * @param src
     * @param <T>
     * @return
     */
    public static <T> T copy(Collection<T> dest, Collection<? extends T> src){
        T last = null;
        for(T t : src){
            last = t;
            dest.add(t);
        }
        return last;
    }

    /**
     * 通配符下限
     * @param <T>
     * @return
     */
    public static <T> T copy2(Collection<? super T> dest, Collection<T> src){
        T last = null;
        for(T t : src){
            last = t;
            dest.add(t);
        }
        return last;
    }

    public static void main(String[] args) {
        List<Number> dest = new ArrayList<>();
        List<Integer> src = new ArrayList<>();
        src.add(12);

        Number number = copy(dest, src);
        System.out.println(number);

        Integer integer = copy2(dest, src);
        System.out.println(integer);
    }
}
