package ch08;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by YouZeng on 2015-05-19.
 */
public class IteratorTest {
    public static void main(String[] args) {
        Collection c = new HashSet();
        c.add("轻量级JavaEE企业级实现");
        c.add("疯狂Java讲义");
        c.add("疯狂Android讲义");
        Iterator i  = c.iterator();
        while(i.hasNext()){
            String book = (String)i.next();
            if("疯狂Java讲义".equals(book)){
                i.remove();
            }
            if("疯狂Android讲义".equals(book)){
//                c.remove(book);
            }
            book = "疯狂Java";
        }
        System.out.println(c);
    }
}
