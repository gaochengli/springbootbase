package java八大排序算法;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

//import com.sun.istack.internal.logging.Logger;

public class 选择排序 {

	public static void main(String[] args) {
//		int [] a = {45,545,88712,213248,655,131232,22,3,23,2,123,22,32,1264,56};
		int [] a = new int[100000];
		Arrays.parallelSetAll(a, i->new Random().nextInt());
//		Logger log = Logger.getLogger(选择排序.class);
//		log.info(Long.toString(new Date().getTime()));
		xuanze(a);
//		log.info(Long.toString(new Date().getTime()));
//		log.info(Arrays.toString(a));
	}

	
	public static int[] xuanze(int[] a) {
		int n = a.length;
		if(n<2) {
			return a;
		}
		for(int j=0;j<n-1;j++) {
			int maxi = 0;
			for(int i=0;i<n-j;i++) {
				if(a[maxi]<a[i]) {
					maxi = i;
				}
			}
			//自身不是剩下数组的最大值，可以执行，即使是也可执行，消耗资源。
			if(maxi != n-j-1) {
				int temp = a[n-j-1];
				a[n-j-1] = a[maxi];
				a[maxi] = temp;
			}
		}
		return a;
	}
}
