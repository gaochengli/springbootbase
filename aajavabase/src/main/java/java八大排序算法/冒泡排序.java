package java八大排序算法;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

//import com.sun.istack.internal.logging.Logger;

public class 冒泡排序 {

	public static void main(String[] args) {
//		int [] a = {45,545,88712,213248,655,131232,22,3,23,2,123,22,32,1264,56};
		int [] a = new int[100000];
		Arrays.parallelSetAll(a, i->new Random().nextInt());
//		Logger log = Logger.getLogger(选择排序.class);
//		log.info(Long.toString(new Date().getTime()));
		maopao(a);
//		log.info(Long.toString(new Date().getTime()));
//		log.info(Arrays.toString(a));
	}

	
	public static int[] maopao(int[] a) {
		int n = a.length;
		if(n<2) {
			return a;
		}
		for(int i=0;i<n-2;i++) {
			for (int j = 0; j < n-1-i; j++) {
				if(a[j]>a[j+1]) {
					int tem = a[j+1];
					a[j+1] = a[j];
					a[j] = tem;
				}
			}
		}
		return a;
	}
}
