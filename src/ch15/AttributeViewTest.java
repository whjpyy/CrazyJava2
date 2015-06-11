package ch15;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by YouZeng on 2015-06-11.
 */
public class AttributeViewTest {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("CrazyJava2/src/ch15/AttributeViewTest.java");
        BasicFileAttributeView view = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        BasicFileAttributes attributes = view.readAttributes();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("创建时间：" + format.format(new Date(attributes.creationTime().toMillis())) );
        System.out.println("最后访问时间：" + format.format(new Date(attributes.lastAccessTime().toMillis())) );
        System.out.println("最后修改时间：" + format.format(new Date(attributes.lastModifiedTime().toMillis())) );
        System.out.println("文件大小：" + attributes.size());
        //获取文件访问属主信息
        FileOwnerAttributeView ownerView = Files.getFileAttributeView(path, FileOwnerAttributeView.class);
        System.out.println("该文件属主：" + ownerView.getOwner());
        //获取系统中guest对应的用户
        UserPrincipal principal = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("guest");
        System.out.println(principal);
        //获取访问自定义属性的
        UserDefinedFileAttributeView userView = Files.getFileAttributeView(path, UserDefinedFileAttributeView.class);
        List<String> attrs = userView.list();
        for(String name : attrs){
            ByteBuffer buffer = ByteBuffer.allocate(userView.size(name));
            userView.read(name, buffer);
            buffer.flip();
            String value = Charset.defaultCharset().decode(buffer).toString();
            System.out.println(name + "--->" + value);
        }
        userView.write("发行者", Charset.defaultCharset().encode("轼佣"));
        //DOS属性
        DosFileAttributeView dosView = Files.getFileAttributeView(Paths.get("out.txt"), DosFileAttributeView.class);
        dosView.setHidden(true);
        dosView.setReadOnly(true);
    }
}
