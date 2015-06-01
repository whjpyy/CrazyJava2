package ch14;

/**
 * Created by YouZeng on 2015-06-01.
 */
public class OverrideTest extends OverrideTestFather{
    @Override
    public void info(){
        System.out.println("子类必须覆盖父类的方法，否则编译错误");
    }

    public static void main(String[] args) {
        new OverrideTest().info();
    }
}

class OverrideTestFather{
    public void info(){

    }
}
