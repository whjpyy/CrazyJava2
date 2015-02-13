package ch04;

/**
 * Created by YouZeng on 2015-02-13.
 */
public class StringSwitchTest {
    public static void main(String[] args) {
        String str = "夏";
        switch (str){
            case "春":
                System.out.println("春天");
                break;
            case "夏":
                System.out.println("夏天");
                break;
            case "秋":
                System.out.println("秋天");
                break;
            case "冬":
                System.out.println("冬天");
                break;
            default:
                System.out.println("输入错误！");
                break;
        }
    }
}
