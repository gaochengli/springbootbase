package java27天成大神.day23.itcast03;

public class ThreadPriorityDemo {

	public static void main(String[] args) {
	
		ThreadPriority tp1 = new ThreadPriority();
		ThreadPriority tp2 = new ThreadPriority();
		ThreadPriority tp3 = new ThreadPriority();
		//设置名称
		tp1.setName("东方");
		tp2.setName("岳不群");
		tp3.setName("林平之");
		//默认优先级
		System.out.println(tp1.getPriority());
		System.out.println(tp2.getPriority());
		System.out.println(tp3.getPriority());
		tp1.setPriority(10);
		tp2.setPriority(1);
		//
		tp1.start();
		tp2.start();
		tp3.start();
	}

}
