package java疯狂讲义;

public class 多进程 {

	public static void main(String[] args) {
		
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i==20) {
				new FirstThread().start();
				new FirstThread().start();
			}
		}

	}

}
