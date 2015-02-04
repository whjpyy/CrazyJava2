package ch03;

public class CircleTest {
	
	private double cx;
	
	public double getCx() {
		return cx;
	}

	public void setCx(double cx) {
		this.cx = cx;
	}

	public static String printSpace(int x){
		String s = "";
		for(int i = 0;i < x;i += 1){
			s += " ";
		}
		return s;
	}
	
	public class Circle{
		private int x;
		private int y;
		private int radix;
		
		Circle(int x, int y, int radix){
			this.x = x;
			this.y = y;
			this.radix = radix;
		}
		
		double caldis(double cy){
			cx = x - Math.sqrt(radix * radix - Math.pow(cy - y, 2));
			return cx;
		}
		
		void print(){
			for(int ry = y + radix; ry >= y - radix; ry -= 2){
				//打印出左边的星号
				System.out.print(CircleTest.printSpace((int)this.caldis(ry)) + "*");
				//接着打印与左边对应的星号，相差(x-cx)*2个空格
				System.out.println(CircleTest.printSpace( (x - (int)this.caldis(ry)) * 2) + "*");
			}
		}
	}

	public static void main(String[] args) {
		CircleTest star = new CircleTest();
		Circle circle = star.new Circle(0, 0, 5000);
		circle.print();
	}
	
}
