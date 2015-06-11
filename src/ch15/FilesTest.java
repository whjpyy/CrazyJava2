package ch15;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YouZeng on 2015-06-10.
 */
public class FilesTest {
    private static String fileBase = "CrazyJava2/src/ch15/";
    public static void main(String[] args) throws IOException {
        //复制文件
        Path my = Paths.get(fileBase + "FilesTest.java");
        Files.copy(my, new FileOutputStream("out.txt"));
        //判断该文件是否是隐藏文件
        System.out.println("是否是隐藏文件：" + Files.isHidden(my));
        //一次性读取该文件的所有行
        List<String> lines = Files.readAllLines(my, Charset.forName("UTF-8"));
        System.out.println(lines);
        //获取文件的大小
        System.out.println(Files.size(my));
        List<String> lists = new ArrayList<>();
        lists.add("床前明月光");
        lists.add("李白想婆娘");
        Files.write(Paths.get("out.txt"), lists, Charset.defaultCharset());
        FileStore fileStore = Files.getFileStore(Paths.get("C:"));
        System.out.println("C的共有空间：" + new BigDecimal(fileStore.getTotalSpace() / 1024 / 1024 / 1024.0).setScale(1, RoundingMode.FLOOR).floatValue()  + "G" );
        System.out.println("C的可用空间：" + new BigDecimal(fileStore.getUsableSpace() / 1024 / 1024 / 1024.0).setScale(1, BigDecimal.ROUND_FLOOR).floatValue() + "G");
    }
}
