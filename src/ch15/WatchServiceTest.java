package ch15;

import java.io.IOException;
import java.nio.file.*;

/**
 * Created by YouZeng on 2015-06-11.
 */
public class WatchServiceTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Paths.get(".").register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
        while (true){
            WatchKey watchKey = watchService.take();
            for (WatchEvent<?> event : watchKey.pollEvents()){
                System.out.println(event.context() + "文件发生了" + event.kind() + "事件");
            }
            //重设watchKey
            boolean b = watchKey.reset();
            if(!b){
                break;
            }
        }
    }
}
