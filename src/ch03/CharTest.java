package ch03;

public class CharTest {

	public static void main(String[] args) {
		System.out.println(0x00ff + ", " + 16 * 16);
		System.out.println(0x0fff + ", " + 16 * 16 * 16);
		System.out.println(0xffff + ", " + 16 * 16 * 16 * 16);
		System.out.println(0b1111 + ", " + 2 * 2 * 2 * 2);
		for(int i = 0;i <= 0x00ff;i += 1){
//			System.out.println(i + "," + (char)(i));
		}
		
	}
}
