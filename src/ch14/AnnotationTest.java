package ch14;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * Created by YouZeng on 2015-06-02.
 */
public class AnnotationTest {
    private JFrame jFrame = new JFrame("使用注解绑定事件");
    @AnnotationListenerFor(listener = OkListerner.class)
    private JButton ok = new JButton("确定");
    @AnnotationListenerFor(listener = CancelListener.class)
    private JButton cancel = new JButton("取消");

    public void init(){
        JPanel jPanel = new JPanel();
        jPanel.add(ok);
        jPanel.add(cancel);
        jFrame.add(jPanel);
        ActionListenerInstaller.process(this);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new AnnotationTest().init();
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface AnnotationListenerFor{
    Class<? extends ActionListener> listener();
}

class OkListerner implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "点击了确定按钮！");
    }
}

class CancelListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "点击了取消按钮！");
    }
}

class ActionListenerInstaller{
    public static void process(Object obj){
        try {
            Class cls = obj.getClass();
            for(Field field : cls.getDeclaredFields()){
                field.setAccessible(true);
                AnnotationListenerFor a = field.getAnnotation(AnnotationListenerFor.class);
                //获取该属性的实际对象
                Object fObj = field.get(obj);
                if(fObj != null && a != null && fObj instanceof AbstractButton){
                    //获取注解里的监视器
                    Class<? extends ActionListener> listenerClazz = a.listener();
                    //获取事件对象
                    ActionListener actionObj = listenerClazz.newInstance();
                    //绑定事件
                    AbstractButton button = (AbstractButton)fObj;
                    button.addActionListener(actionObj);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}