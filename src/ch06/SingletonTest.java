package ch06;

/**
 * 单例模式
 * @author YouZeng
 */
class Singleton{
	private Singleton(){}
	private static Singleton singleton;
	public static Singleton getInstance(){
		if(singleton == null){
			singleton = new Singleton();
		}
		return singleton;
	}
}

public class SingletonTest {

	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1 == s2);
	}
	
}
