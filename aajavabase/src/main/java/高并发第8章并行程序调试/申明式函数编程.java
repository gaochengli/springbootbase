package 高并发第8章并行程序调试;

import java.util.Arrays;

public class 申明式函数编程 {

	public static void main(String[] args) {
	
		//原来是传统 命令式
//		int [] iArr = {23,25,95,889,55,887,566};
//		for (int i = 0; i < iArr.length; i++) {
//			System.out.println(iArr[i]);
//		}
		//申明式
		int [] iArr = {23,25,95,889,55,887,566};
		Arrays.stream(iArr).forEach(System.out::println);
	}

}
