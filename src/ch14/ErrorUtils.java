package ch14;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by YouZeng on 2015-06-01.
 */
public class ErrorUtils {

    @SafeVarargs
    public static void faultyMethod(List<String>... listStrArray){
        List[] listArray = listStrArray;
        List<Integer> myList = new ArrayList<>();
        myList.add(new Random().nextInt(100));
        listArray[0] = myList;
        String s = listStrArray[0].get(0);
    }

    public static void main(String[] args) {
        faultyMethod(new ArrayList<String>());
    }
}
