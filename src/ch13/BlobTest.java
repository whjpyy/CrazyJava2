package ch13;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by YouZeng on 2015-05-26.
 */
public class BlobTest {
    JFrame jf = new JFrame("图片管理程序");
    private static Connection conn;
    private static PreparedStatement insert;
    private static PreparedStatement query;
    private static PreparedStatement queryAll;
    //定义一个DefaultListModel对象
    private DefaultListModel<ImageHolder> imageModel = new DefaultListModel<>();
    private JList<ImageHolder> imageList = new JList<>(imageModel);
    private JTextField filePath = new JTextField(26);
    private JButton browerBn = new JButton("...");
    private JButton uploadBn = new JButton("上传");
    private JLabel imageLabel = new JLabel();
    //以当前路径创建文件选择器
    JFileChooser chooser = new JFileChooser(".");
    //创建文件过滤器
    ExtensionFileFilter filter = new ExtensionFileFilter();

    private static final String BASE_DIR = System.getProperty("user.dir") + "/CrazyJava2/src/";
    static {
        try{
            Properties properties = new Properties();
            properties.load(new FileInputStream(BASE_DIR + "mysql.ini"));
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            //创建执行插入的PreparedStatement对象
            //该对象执行插入后可以返回自动生成的主键
            insert = conn.prepareStatement("insert into img_table(img_name, img_data2) values(?, ?);");
            //创建两个PreparedStatement对象用户查询图片和查询所有图片
            query = conn.prepareStatement("select img_data from img_table where img_id = ?");
            queryAll = conn.prepareStatement("select img_id, img_name from img_table");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void init() throws SQLException{
        //初始化文件选择器
        filter.addExtension("jpg");
        filter.addExtension("jpeg");
        filter.addExtension("gif");
        filter.addExtension("png");
        filter.setDescription("图片文件(*.jpg,*jpeg,*.gif,*.png)");
        chooser.setFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false);
        //----------初始化界面------------
        fillListModel();
        filePath.setEditable(false);
        //只能单选
        imageList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JPanel jp = new JPanel();
        jp.add(filePath);
        jp.add(browerBn);
        browerBn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //显示文件对话框
                int result = chooser.showDialog(jf, "浏览图片文件上传");
                if (result == JFileChooser.APPROVE_OPTION) {
                    filePath.setText(chooser.getSelectedFile().getPath());
                }
            }
        });
        jp.add(uploadBn);
        uploadBn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(filePath.getText().trim().length() > 0){
                    upload(filePath.getText());
                    //清空文本框内容
                    filePath.setText("");
                }
            }
        });
        JPanel left = new JPanel();
        left.setLayout(new BorderLayout());
        left.add(new JScrollPane(imageLabel), BorderLayout.CENTER);
        left.add(jp, BorderLayout.SOUTH);
        jf.add(left);
        imageList.setFixedCellWidth(160);
        jf.add(new JScrollPane(imageList), BorderLayout.EAST);
        imageList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //如果双击鼠标
                if(e.getClickCount() >= 2){
                    //取出选中的List项
                    ImageHolder cur = (ImageHolder)imageList.getSelectedValue();
                    try{
                        showImage(cur.getId());
                    }catch (SQLException ev){
                        ev.printStackTrace();
                    }
                }
            }
        });
        jf.setSize(620, 400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }

    private void showImage(int id) throws SQLException {
        query.setInt(1, id);
        try(ResultSet rs = query.executeQuery()){
            if(rs.next()){
                //取出Blob列
                Blob imgBlob = rs.getBlob(1);
                //取出Blob列里的数据
                ImageIcon icon = new ImageIcon(imgBlob.getBytes(1L, (int)imgBlob.length()));
                imageLabel.setIcon(icon);
            }
        }
    }

    private void upload(String fileName) {
        //截取文件名
        String imageName = fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.lastIndexOf("."));
        File file = new File(fileName);
        try(InputStream is = new FileInputStream(file)){
            //设置图片名参数
            insert.setString(1, imageName);
            insert.setBinaryStream(2, is, (int)file.length());
            int effect = insert.executeUpdate();
            if(effect == 1){
                fillListModel();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //查找img_table表填充ListModel
    private void fillListModel() throws SQLException {
        try(ResultSet set = queryAll.executeQuery()){
            //先清除所有的元素
            imageModel.clear();
            while (set.next()){
                imageModel.addElement(new ImageHolder(set.getInt(1), set.getString(2)));
            }
        }
    }

    public static void main(String[] args) throws SQLException, IOException {
//        new BlobTest().init();
        File f = new File("C:\\Users\\YouZeng\\Desktop\\2.jpg");
        InputStream fis = new FileInputStream(f);
        insert.setString(1, "图片啊。。");
//        insert.setBlob(2, new Blo);
//        System.out.println(f.length());
//        insert.setBinaryStream(2, fis, (int) f.length());
        insert.setBinaryStream(2, fis, fis.available());
//        insert.setBinaryStream(2, fis, fis.available());
//        insert.setBlob(2, new FileInputStream(new File("C:\\Users\\YouZeng\\Desktop\\QQ20150526172939.png")));
//        insert.setBinaryStream(2, new FileInputStream(new File("C:\\Users\\YouZeng\\Desktop\\QQ20150526172939.png")));
        insert.executeUpdate();
    }
}

class ExtensionFileFilter extends FileFilter{

    private String description = "";
    private ArrayList<String> extensions = new ArrayList<>();

    //自定义方法，用于添加文件扩展名
    public void addExtension(String extension){
        if(!extension.endsWith(".")){
            extension = "." + extension;
            extensions.add(extension.toLowerCase());
        }
    }

    //判断该文件过滤器是否接受该文件
    public boolean accept(File f) {
        if(f.isDirectory()){
            return true;
        }
        String name = f.getName().toLowerCase();
        for(String extension : extensions){
            if(name.endsWith(extension)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
class ImageHolder{

    private int id;
    private String name;
    public ImageHolder(){}
    public ImageHolder(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String toString(){
        return name;
    }
}