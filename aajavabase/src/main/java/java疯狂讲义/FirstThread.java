package java疯狂讲义;

public class FirstThread extends Thread {

	private int i;
	@Override
	public void run() {
		for (; i < 100; i++) {
			System.out.println(getName()+" "+i);
		}
	}
	
}
