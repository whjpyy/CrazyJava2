package ch07;

import java.io.IOException;

/**
 * Created by YouZeng on 2015-05-18.
 */
public class ExecTest {

    public static void main(String[] args) throws IOException {
        Runtime rt = Runtime.getRuntime();
        System.out.println("处理器数量：" + rt.availableProcessors() + ", 空闲内存：" + rt.freeMemory() + ", 总内存：" +
            rt.totalMemory() + ", 可用最大内存：" + rt.maxMemory());
        //调用程序
        rt.exec("notepad.exe");
    }
}
