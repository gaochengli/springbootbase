package 高并发第8章并行程序调试;

public class 线程中断 {

	public static void main(String[] args) throws InterruptedException {
		
/*		Thread t1 = new Thread() {
			@Override
			public void run() {
				while(true) {
					Thread.yield();
				}
			}
		};
		t1.start();
		Thread.sleep(2000);
		t1.interrupt();*/
		Thread t = new Thread() {
			@Override
			public void run() {
				while(true) {
					if(Thread.currentThread().isInterrupted()) {
						System.out.println("中断了");
						break;
					}
					System.out.println("尾端");
					Thread.yield();
				}
			}
		};
		t.start();
		Thread.sleep(2000);
		t.interrupt();

	}

}
