package ch15;

import java.nio.CharBuffer;

/**
 * Created by YouZeng on 2015-06-08.
 */
public class BufferTest {

    public static void main(String[] args) {
        CharBuffer cb = CharBuffer.allocate(8);
        System.out.println("capacity: " + cb.capacity());
        System.out.println("limit: " + cb.limit());
        System.out.println("position: " + cb.position());
        cb.put('a');
        cb.put('b');
        cb.put('c');
        System.out.println("加入3个元素后的position: " + cb.position());
        cb.flip();
        System.out.println("调用flip()后的limit:" + cb.limit());
        System.out.println("position:" + cb.position());
        System.out.println("取出第一元素：" + cb.get());
        System.out.println("position: " + cb.position());
        cb.clear();
        System.out.println("调用clear()后的limit：" + cb.limit());
        System.out.println("调用clear()后的position：" + cb.position());
        System.out.println("调用clear()后，缓存区内容并没有清除:" + cb.get(2));
        System.out.println("position: " + cb.position());
    }
}
