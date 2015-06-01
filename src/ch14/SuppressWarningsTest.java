package ch14;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YouZeng on 2015-06-01.
 */
public class SuppressWarningsTest {

    @SuppressWarnings(value = "unchecked")
    public void info(){
        List list = new ArrayList();
        list.add(1);
        System.out.println(list);
        System.out.println("忽略编译提示信息！");
    }

    public static void main(String[] args) {
        new SuppressWarningsTest().info();
    }
}
