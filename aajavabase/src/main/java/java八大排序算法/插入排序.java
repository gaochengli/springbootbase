package java八大排序算法;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

//import com.sun.istack.internal.logging.Logger;

public class 插入排序 {

	public static void main(String[] args) {
//		int [] a = {45,545,88712,213248,655,131232,22,3,23,2,123,22,32,1264,56};
		int [] a = new int[100000];
		Arrays.parallelSetAll(a, i->new Random().nextInt());
//		Logger log = Logger.getLogger(插入排序.class);
//		log.info(Long.toString(new Date().getTime()));
		charu(a);
//		log.info(Long.toString(new Date().getTime()));
//		log.info(Arrays.toString(a));
	}

	
	public static int[] charu(int[] a) {
		int n = a.length;
		if(n<2) {
			return a;
		}
		for(int i=1;i<n;i++) {
			int nowNum = a[i];
			int j = i - 1;
			
		}
		return a;
	}
}
