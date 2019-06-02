package 同步锁;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 新建线程 {

	public static void main(String[] args) {
		
		Dthread t = new Dthread();
		t.start();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				System.out.println("匿名内部类");
			}
		};
		t1.start();
		ArrayList a = new ArrayList<String>() {
			@Override
			public String toString() {
				return "a";
			}
		};
		System.out.println(a.toString());
		t.stop();
	}
	
	static class Dthread extends Thread{
		@Override
		public void run() {
			int n = 10;
			for(int i = 1; i <= n; i ++){
	            for(int j = 1; j < i; j ++){
	                System.out.print("   ");
	            }
	            for(int j = i; j <= n; j ++){
	                if(i == 1 || j == i|| i == n)
	                    System.out.print(" * ");
	                else
	                    System.out.print("   ");
	            }
	            for(int j = i; j < n; j ++){
	                if(i == 1 || j == n - 1)
	                    System.out.print(" * ");
	                else
	                    System.out.print("   ");
	            }
	            System.out.println();
	        }
		}
	}

}
