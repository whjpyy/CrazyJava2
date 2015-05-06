package ch06;

import java.lang.ref.WeakReference;

public class ReferenceTest {

	public static void main(String[] args) {
		String str = new String("Java");
		WeakReference<String> wr = new WeakReference<String>(str);
		str = null;
		System.out.println(wr.get());
		System.gc();
		System.runFinalization();
		System.out.println(wr.get());
	}
}
