package 高并发第8章并行程序调试;

import java.io.Closeable;
import java.util.Arrays;
import java.util.function.IntConsumer;

public class 更少的代码 {
	static int[] arr = {56,689,41,415151,161,161,61,51,88,44,66,22};
	public static void main(String[] args) {
//		for (int i = 0; i < arr.length; i++) {
//			if(arr[i]%2!=0) {
//				arr[i]++;
//			}
//			System.out.println(arr[i]);
//		}
//		Arrays.stream(arr).map(x->(x%2==0?x:x+1)).forEach(System.out::println);
		IntConsumer opl = System.out::println;
		IntConsumer epl = System.err::println;
		Arrays.stream(arr).forEach(opl.andThen(epl));
	}

}
