package 同步锁;

import java.security.AlgorithmConstraints;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockMain {

	private ArrayList<Integer> al = new ArrayList<Integer>();
	private Lock lock = new ReentrantLock();
	
	public static void main(String[] args) {
		final LockMain test = new LockMain();
//		test.al = new ArrayList<Integer>();
		new Thread("ggg") {
			@Override
			public void run() {
				test.insert(Thread.currentThread());
			}
		}.start();
		new Thread("ccc") {
			@Override
			public void run() {
				test.insert(Thread.currentThread());
			}
		}.start();
	}
	
	public void insert(Thread thread) {
		if(lock.tryLock()) {
		try {
			System.out.println(thread.getName()+"得到了锁！");
			for (int i = 0; i < 5; i++) {
				al.add(i);
				System.out.println(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(thread.getName()+"释放了锁！");
			lock.unlock();
		}
		}
}
}