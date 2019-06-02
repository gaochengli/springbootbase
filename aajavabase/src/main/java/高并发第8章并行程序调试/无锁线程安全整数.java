package 高并发第8章并行程序调试;

import java.util.concurrent.atomic.AtomicInteger;

public class 无锁线程安全整数 {

	static AtomicInteger i = new AtomicInteger();
	
	public static class AddThread implements Runnable{

		@Override
		public void run() {
			for (int k = 0; k < 10000; k++) {
				i.incrementAndGet();
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		
		

	}

}
