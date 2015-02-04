package ch03;

public class FloatTest {

	public static void main(String[] args) {
		float af = 5.2345556f;
		System.out.println(af);
		double a = 0.0;
		double c = Double.NEGATIVE_INFINITY;
		float d  = Float.NEGATIVE_INFINITY;
		System.out.println(c == d);
		System.out.println(a / a);
		System.out.println(a / a == Float.NaN);
		//所有的正无穷大都是相等的
//		System.out.println( (6.0 / 0) == (555.0 / 0));
		System.out.println(-8 / a);
	}
}
