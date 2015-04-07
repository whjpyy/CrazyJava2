package ch06;

/**
 * 简单工厂模式
 * @author YouZeng
 *
 */
interface Output{
	int MAX_CACHE_LINE = 1;
	public void getData(String msg);
	public void out();
}

class Printer implements Output{
	public void getData(String msg) {
	}
	public void out() {
	}
}

class BetterPrinter implements Output{
	private String[] printData = new String[MAX_CACHE_LINE * 2];
	//用以记录当前需打印的作业数
	private int dataNum = 0;
	public void getData(String msg) {
		if(dataNum >= MAX_CACHE_LINE * 2){
			System.out.println("输出队列已满，添加失败");
		}else{
			printData[dataNum++] = msg;
		}
	}
	public void out() {
		//只要还有作业，就继续打印
		while(dataNum > 0){
			System.out.println("高速打印机正在打印：" + printData[0]);
			//把作业队列整体前移以为，并将剩下的作业减1
			System.arraycopy(printData, 1, printData, 0, --dataNum);
		}
	}
}

class OutputFactory{
	public Output getOutput(){
		return new BetterPrinter();
	}
}

public class Computer {
	private Output out;
	public Computer(Output out){
		this.out = out;
	}
	//定义一个模拟获取字符串输入的方法
	public void keyIn(String msg){
		out.getData(msg);
	}
	//定义一个模拟打印的方法
	public void print(){
		out.out();
	}
	
	public static void main(String[] args) {
		OutputFactory of = new OutputFactory();
		Computer c = new Computer(of.getOutput());
		c.keyIn("轻量级JavaEE企业应用实战");
		c.keyIn("疯狂Java讲义");
		c.print();
		c.keyIn("呵呵");
		c.print();
	}
}