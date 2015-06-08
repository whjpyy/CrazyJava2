package ch15;

import java.io.*;

/**
 * Created by YouZeng on 2015-06-08.
 */
public class InsertContentTest {

    public static void insert(String fileName, long pos, String insertContent) throws IOException {

        File temp = File.createTempFile("temp", null);
        temp.deleteOnExit();

        try(RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
            FileInputStream fis = new FileInputStream(temp);
            FileOutputStream fos = new FileOutputStream(temp)
        ){
            raf.seek(pos);
            //先读取之后的内存存储在临时文件中
            int hasRead = 0;
            byte[] bytes = new byte[1024];
            while( (hasRead = raf.read(bytes)) > 0 ){
                fos.write(bytes, 0, hasRead);
            }
            //添加内容
            raf.seek(pos);
            raf.write(insertContent.getBytes());
            //读取临时表中内容添加
            while( (hasRead = fis.read(bytes)) > 0){
                raf.write(bytes, 0, hasRead);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        insert("out.txt", 9, "中间插入的数据\r\n");

        RandomAccessFile raf = new RandomAccessFile("out.txt", "rw");
        System.out.println(raf.length());
    }
}
