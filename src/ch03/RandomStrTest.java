package ch03;

/**
 * 随机生成6位数的字符串
 * @author YouZeng
 */
public class RandomStrTest {

	public static void main(String[] args) {
		String result = "";
		for(int i = 0;i < 6;i += 1){
			char c = (char)(Math.random() * 26 + 97);
			result += c;
		}
		System.out.println(result);
	}
}
