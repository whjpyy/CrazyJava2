package ch15;

import java.io.File;
import java.io.IOException;

/**
 * Created by YouZeng on 2015-06-02.
 */
public class FileTest {

    public static void main(String[] args) throws IOException {
        File file = new File(".");
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsoluteFile().getParent());
        File tempFile = File.createTempFile("aaa", ".txt", file);
        tempFile.deleteOnExit();
        File newFile = new File(System.currentTimeMillis() + "");
        System.out.println("newFile对象是否存在：" + newFile.exists());
        System.out.println(newFile.createNewFile());
        System.out.println(newFile.mkdir());
        String[] fileList = file.list();
        for(String fileName : fileList){
            System.out.println(fileName);
        }
        File[] roots = File.listRoots();
        System.out.println("====系统所有根路径如下=====");
        for(File root : roots){
            System.out.println(root);
        }
    }
}
