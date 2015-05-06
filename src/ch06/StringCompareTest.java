package ch06;

/**
 * 常量池
 * @author YouZeng
 *
 */
public class StringCompareTest {

	public static void main(String[] args) {
		String s1 = "疯狂Java";
		String s2 = "疯狂";
		String s3 = "Java";
		String s4 = "疯狂" + "Java";
		String s5 = "疯" + "狂" + "Java";
		String s6 = s2 + s3;
		String s7 = new String("疯狂Java");
		System.out.println(s1 == s4);
		System.out.println(s1 == s5);
		System.out.println(s1 == s6);
		System.out.println(s1 == s7);
	}
}
