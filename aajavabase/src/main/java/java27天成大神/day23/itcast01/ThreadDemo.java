package java27天成大神.day23.itcast01;

public class ThreadDemo {

	public static void main(String[] args) {
		MyThread mt = new MyThread("mt");
		MyThread mt2 = new MyThread("mt2");
		//自动调用
		mt.start();
		mt2.start();
	}

}
