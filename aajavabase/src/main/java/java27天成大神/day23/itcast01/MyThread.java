package java27天成大神.day23.itcast01;

public class MyThread extends Thread{
	
	public static int i = 100;
	
	private String d;
	
	public MyThread(String d) {
		this.d = d;
	}

	@Override
	public void run() {
		while(i>0) {
			System.out.println("生气"+i+d);
			i--;
		}
	}
	
}
