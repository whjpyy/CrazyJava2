package ch10;

/**
 * Created by YouZeng on 2015-05-21.
 */
public class FinalFlowTest {
    public static boolean test(){
        try{
            return true;
        }finally {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(test());
    }
}
