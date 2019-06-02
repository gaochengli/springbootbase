package java27天成大神.day23.itcast05;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		for (int x = 0; x < 100; x++) {
			System.out.println(Thread.currentThread().getName() + ":" + x);
		}
	}
	
	
	
}
