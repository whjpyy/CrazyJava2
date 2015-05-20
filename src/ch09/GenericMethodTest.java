package ch09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by YouZeng on 2015-05-20.
 */
public class GenericMethodTest {

    public static <T> void copyArrayToCollection(T[] arr, Collection<T> c){
        for(T t : arr){
            c.add(t);
        }
    }

    public static void main(String[] args) {
        String[] strings = new String[10];
        List<String> stringList = new ArrayList<>();
        GenericMethodTest.copyArrayToCollection(strings, stringList);
        System.out.println(stringList);

        Float[] floats = new Float[2];
        List<Float> floatList = new ArrayList<>();
        GenericMethodTest.copyArrayToCollection(floats, floatList);
        System.out.println(floatList);
    }
}
