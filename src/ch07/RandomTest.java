package ch07;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by YouZeng on 2015-05-18.
 * JDK1.7 新增ThreadLocalRandom类
 */
public class RandomTest {

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("random.nextBoolean(): " + random.nextBoolean());
        byte[] buffer = new byte[16];
        random.nextBytes(buffer);
        //生成0.0 - 1.0之间的伪随机double数
        System.out.println("random.nextDouble(): " + random.nextDouble());
        //生成0.0 - 1.0之间的伪随机float数
        System.out.println("random.nextFloat(): " + random.nextFloat());
        System.out.println("random.nextInt(): " + random.nextInt() );
        System.out.println("radnom.nextInt(26): " + random.nextInt(26));
        System.out.println("random.nextLong(): " + random.nextLong());
        //ThreadLocalRandom
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        System.out.println(tlr.nextInt(0, 24));
        System.out.println(tlr.nextDouble(2.0, 4.0));
    }
}
