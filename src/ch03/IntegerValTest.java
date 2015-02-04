package ch03;

public class IntegerValTest {

	public static void main(String[] args) {
		//定义两个8位的二进制整数
		int binVal1 = 0b11010100;
		byte binVal2 = 0b01101001;
		//定义一个32为的二进制整数,最高位为符号位
		int binVal3 = 0B10000000000000000000000000000011;
		int binVal4 = 0b101;
		System.out.println(binVal1);
		System.out.println(binVal2);
		System.out.println(binVal3);
		System.out.println(binVal4);
	}
}
