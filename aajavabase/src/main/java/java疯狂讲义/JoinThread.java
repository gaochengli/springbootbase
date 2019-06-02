package java疯狂讲义;

public class JoinThread extends Thread{

	//有参构造器，设置线程名字
	public  JoinThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println(getName()+" "+i);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
	
		JoinThread jjj = new JoinThread("天河一号线程");
		jjj.start();
		for(int i=0;i<100;i++) {
			if(i == 20) {
				JoinThread jt = new JoinThread("join线程");
				jt.start();
				//必须等jt执行结束才能继续向前
				jt.join();
				jjj.sleep(3000);
			}
			System.out.println(Thread.currentThread().getName()+" "+i);
		}

	}

}
