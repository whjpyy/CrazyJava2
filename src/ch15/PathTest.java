package ch15;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by YouZeng on 2015-06-10.
 */
public class PathTest {

    public static void main(String[] args) {
        Path path = Paths.get(".");
        System.out.println("Path里面包含的路径：" + path.getNameCount());
        System.out.println("Path的根目录：" + path.getRoot());

        Path aPath = path.toAbsolutePath();
        System.out.println("Path的绝对路径：" + aPath);
        System.out.println("Path根目录的绝对路径：" + aPath.getRoot());
        System.out.println("Path绝对路径包含的目录：" + aPath.getNameCount());
        System.out.println("绝对路径的第1个路径名：" + aPath.getName(0));
        //以多个String来构建Path对象
        Path newPath = Paths.get("D:", "Work", "Workspace", "IntelliJ IDEA 14", "JavaWorkspace", "out.txt");
        System.out.println(newPath);


    }
}
