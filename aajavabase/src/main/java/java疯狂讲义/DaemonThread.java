package java疯狂讲义;

public class DaemonThread extends Thread{
	
	public DaemonThread(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(getName()+" "+i);
		}
	}
	
	public static void main(String[] args) {
		
		DaemonThread t = new DaemonThread("守护线程");
		t.setDaemon(true);
		t.start();
		for(int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
		}

	}

}
