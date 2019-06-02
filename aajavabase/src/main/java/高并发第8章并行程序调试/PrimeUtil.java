package 高并发第8章并行程序调试;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.IntStream;

/*
 * 使用并行
 */
public class PrimeUtil {
	public static void main(String[] args) {
/*		System.out.print(new Date().toString());
		System.out.print(IntStream.range(1, 10000000).filter(PrimeUtil::isPrime).count());
		System.out.print(new Date().toString());*/
		//并行
/*	*/	System.out.print(new Date().toString());
		System.out.print(IntStream.range(1, 100000000).parallel().filter(PrimeUtil::isPrime).count());
		System.out.println(Arrays.toString(IntStream.range(1, 10000000).parallel().filter(PrimeUtil::isPrime).toArray()));
		System.out.print(new Date().toString());
//		System.out.println(Arrays.toString(IntStream.range(1, 1000000).filter(PrimeUtil::isPrime).toArray()));
	}
	
	public static boolean isPrime(int number) {
		int tmp = number;
		if(tmp<2) {
			return false;
		}
		for(int i = 2;Math.sqrt(tmp)>=i;i++) {
			if (tmp%i == 0) {
				return false;
			}
		}
		return true;
	}

}
