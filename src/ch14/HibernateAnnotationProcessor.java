package ch14;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Set;

/**
 * Created by YouZeng on 2015-06-02.
 */
@SupportedSourceVersion(SourceVersion.RELEASE_7)
//指定要处理的注解
@SupportedAnnotationTypes({"Persistent", "Id", "Property"})
public class HibernateAnnotationProcessor extends AbstractProcessor{

    //循环处理每个需要处理的程序对象
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        //定义一个文件输出流，用于生成额外的文件
        PrintStream ps = null;
        try{
            //遍历每个被@Persistent修饰的class文件
            for(Element t : roundEnv.getElementsAnnotatedWith(Persistent.class)){
                //获取类名
                Name clazzName = t.getSimpleName();
                Persistent per = t.getAnnotation(Persistent.class);
                //创建文件输出流
                ps = new PrintStream(new FileOutputStream(clazzName + ".hbm.xml"));
                //执行输出
                ps.println("<?xml version=\"1.0\"?>");
                ps.println("<!DOCTYPE hibernate-mapping PUBLIC \"-//Hibernate/Hibernate Mappiing DTD"
                 + " 3.0//EN\" ");
                ps.println("\"http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd\">");
                ps.println("<hibernate-mapping><class name=\"" + t + "\" table=\"" + per.table() + "\">");
                for(Element f : t.getEnclosedElements()){
                    //只处理Field上的Annotation
                    if(f.getKind() == ElementKind.FIELD){
                        Id id = f.getAnnotation(Id.class);
                        if(id != null){
                            ps.println("<id name=\"" + f.getSimpleName() + "\" column=\"" +
                                id.column() + "\" type=\"" + id.type() + "\" >" );
                            ps.println("<generator class=\"" + id.generator() + "\" />");
                            ps.println("</id>");
                        }
                        //获取Field的Property注解
                        Property p = f.getAnnotation(Property.class);
                        if(p != null){
                            ps.println("<property name=\"" + f.getSimpleName() + "\" column=\"" +
                                    p.column() + "\" type=\"" + p.type() + "\" />" );
                        }
                    }
                }
                ps.println("</class></hibernate-mapping>");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(ps != null){
                try{
                    ps.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
