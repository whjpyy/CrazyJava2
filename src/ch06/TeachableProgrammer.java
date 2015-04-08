package ch06;

interface Teachable{
	void work();
}

class Programmer{
	private String name;
	public Programmer(){}
	public Programmer(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void work(){
		System.out.println(name + "在灯下认真敲键盘...");
	}
}

/**
 * 闭包
 * @author YouZeng
 */
public class TeachableProgrammer extends Programmer{
	public TeachableProgrammer(){}
	public TeachableProgrammer(String name){
		super(name);
	}
	//教学工作依然由TeachableProgrammer定义
	private void teach(){
		System.out.println(getName() + "老师在讲台上讲解...");
	}
	private class Closure implements Teachable{
		/**
		 * 非静态内部类回调外部类实现work方法，非静态内部类引用的作业仅仅是
		 * 向客户类提供一个回调外部类的途径
		 */
		public void work() {
			teach();
		}
	}
	public Teachable getCallbackReference(){
		return new Closure();
	}
	
	public static void main(String[] args) {
		TeachableProgrammer t = new TeachableProgrammer("Chen");
		t.work();
		t.getCallbackReference().work();
	}
}
