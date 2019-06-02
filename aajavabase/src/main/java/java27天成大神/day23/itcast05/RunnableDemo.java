package java27天成大神.day23.itcast05;

public class RunnableDemo {

	public static void main(String[] args) {
		MyRunnable my = new MyRunnable();
		Thread t1 = new Thread(my, "meng");
		Thread t2 = new Thread(my, "le");
		//启动
		t1.start();
		t2.start();
	}
	
}
