package ch15;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by YouZeng on 2015-06-02.
 */
public class FilenameFilterTest {
    public static void main(String[] args) {
        File file = new File(".");
        String[] files = file.list(new MyFilenameFilter());
        for(String f : files){
            System.out.println(f);
        }
    }
}

class MyFilenameFilter implements FilenameFilter{

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith("iml") || new File(name).isDirectory();
    }
}
