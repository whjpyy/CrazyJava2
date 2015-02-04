package ch03;

/**
 * Description:
 * <br />疯狂Java 联盟
 * @author YouZeng
 * @version 1.0
 */
public class JavaDocTest {

	/*
	 * 简单测试Field
	 */
	protected String name;
	static int a;
	boolean b;
	
	/*
	 * 主方法，程序的入口 
	 */
	public static void main(String[] args) {
		JavaDocTest obj = new JavaDocTest();
		System.out.println(obj.b);
		System.out.println(a);
		System.out.println("Hello World!");
	}
}
