package 同步锁;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockReadWriteMain {

	private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	
	
	
	public static void main(String[] args) {
		
		final LockReadWriteMain lrwm = new LockReadWriteMain();
		
		 new Thread("读写gcl"){
	            public void run() {
//	            	lrwm.get(Thread.currentThread());
	            	lrwm.set(Thread.currentThread());
	            };
	        }.start();
	         
	        new Thread("读写wxy"){
	            public void run() {
//	            	lrwm.get(Thread.currentThread());
	            	lrwm.set(Thread.currentThread());
	            };
	        }.start();
	}
	
	public void get(Thread thread) {
		rwl.readLock().lock();
        try {
            long start = System.currentTimeMillis();
             
            while(System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName()+"正在进行读操作");
            }
            System.out.println(thread.getName()+"读操作完毕");
        } finally {
            rwl.readLock().unlock();
        }
	}
	public void set(Thread thread) {
		rwl.writeLock().lock();
		try {
			long start = System.currentTimeMillis();
			
			while(System.currentTimeMillis() - start <= 1) {
				System.out.println(thread.getName()+"正在进行读操作");
			}
			System.out.println(thread.getName()+"读操作完毕");
		} finally {
			rwl.writeLock().unlock();
		}
	}

}
