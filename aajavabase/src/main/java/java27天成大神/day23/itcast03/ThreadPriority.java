package java27天成大神.day23.itcast03;

public class ThreadPriority extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.println(getName()+":"+i);
		}
	}
}
