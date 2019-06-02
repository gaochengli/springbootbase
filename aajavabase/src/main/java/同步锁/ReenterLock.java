package 同步锁;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterLock implements Runnable{

	public static ReentrantLock lock = new ReentrantLock();
	public static int i = 0;
	@Override
	public void run() {
		
		for (int j = 0; j < 10000000; j++) {
			lock.lock();
			try {
				i++;
				System.out.println(i);
			}finally {
				lock.unlock();
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		ReenterLock t = new ReenterLock();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		t2.start();t1.start();
		t2.join();t1.join();
		System.out.println(i);
	}
	
}









































