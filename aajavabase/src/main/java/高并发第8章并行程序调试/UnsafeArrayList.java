package 高并发第8章并行程序调试;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.event.TreeWillExpandListener;

public class UnsafeArrayList {

	static ArrayList al = new ArrayList();
	
	static class AddTask implements Runnable{

		@Override
		public void run() {
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				for (int i = 0; i < 1000000; i++) {
					al.add(new Object());
				}
			}
			
		}
		
	}
	
	public enum status {
		
		t1,t2,t3,t4
		
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(Thread.State.values()));
//		Thread t1 = new Thread(new AddTask(),"T1");
//		Thread t2 = new Thread(new AddTask(),"T2");
//		t1.start();
//		t2.start();
//		Thread t3 = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				
//				while (true) {
//					
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO: handle exception
//					}
//					
//				}
//				
//			}
//		},"t3");
//		t3.start();
	}
	
}

























