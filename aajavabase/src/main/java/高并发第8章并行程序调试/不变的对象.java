package 高并发第8章并行程序调试;

import java.util.Arrays;

public class 不变的对象 {

	/**
	 * @param args
	 */
	static int [] arr = {4,65,65,887987,56564,656,546};
	public static void main(String[] args) {
		Arrays.stream(arr).map((x)->x=x+1).forEach(System.out::println);
		System.out.println();
		Arrays.stream(arr).forEach(System.out::println);
	}

}
