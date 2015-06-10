package ch15;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * Created by YouZeng on 2015-06-10.
 */
public class CharsetTransformTest {

    public static void main(String[] args) throws CharacterCodingException {
        Charset charset = Charset.forName("GBK");
        CharsetEncoder encoder = charset.newEncoder();
        CharsetDecoder decoder = charset.newDecoder();
        CharBuffer buffer = CharBuffer.allocate(8);
        buffer.put('孙');
        buffer.put('悟');
        buffer.put('空');
        buffer.put('空');
        buffer.flip();

        ByteBuffer byteBuffer = encoder.encode(buffer);
        for(int i = 0;i < byteBuffer.capacity();i += 1){
            System.out.print(byteBuffer.get(i) + " | ");
        }
        System.out.println();
        byte[] bytes = "孙悟空空".getBytes(charset);
        for(int i = 0;i < bytes.length;i += 1){
            System.out.print(bytes[i] + " | ");
        }
        System.out.println("\n" + decoder.decode(byteBuffer));
    }
}
