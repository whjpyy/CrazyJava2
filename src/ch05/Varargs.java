package ch05;

/**
 * JDK1.5 支持可变的形参
 * @author YouZeng
 *
 */
public class Varargs {

	public static void show(int a, String... books){
		for(String book : books){
			System.out.println(book);
		}
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		Varargs.show(2, "Java", "Javascript");
	}
}
