package 高并发第8章并行程序调试;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class 并行排列 {
	public static void main(String[] args) {
		System.out.print(new Date().toString());
		int [] arr = new int[1000000];
		Random r = new Random();
//		Arrays.setAll(arr, (i)->r.nextInt());
		Arrays.parallelSetAll(arr,(i)->r.nextInt());
		Arrays.parallelSort(arr);
		System.out.print(Arrays.toString(arr));
		System.out.print(new Date().toString());
	}

}
