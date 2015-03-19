package ch05;

/**
 * 递归
 * @author YouZeng
 *
 */
public class Recursive {

	/**
	 * f(20)=1, f(21)=4, f(n+2)=2*f(n+1)+f(n), 求f(10) 
	 * @param n
	 * @return
	 */
	public static int fn(int n){
		if(n == 20){
			return 1;
		}else if(n == 21){
			return 4;
		}else{
			return fn(n + 2) - 2 * fn(n + 1);
		}
	}
	
	/**
	 * f(0)=1, f(1)=4, f(n+2)=2*f(n+1)+f(n), 求f(10) 
	 * @param n
	 * @return
	 */
	public static int fn2(int n){
		if(n == 0){
			return 1;
		}else if(n == 1){
			return 4;
		}else{
			return 2 * fn2(n - 1) + fn2(n - 2);
		}
	}
	
	public static void main(String[] args) {
//		System.out.println(fn(10));
//		System.out.println(fn2(10));
		
		System.out.println(Boolean.TYPE);
		System.out.println(new Boolean("True"));
	}
}
