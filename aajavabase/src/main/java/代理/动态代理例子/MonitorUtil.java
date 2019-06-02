/**
 * 
 */
package 代理.动态代理例子;

/**
 * @author clgao
 * 检测方法执行的工具类
 */
public class MonitorUtil {

	private static ThreadLocal<Long> t1 = new ThreadLocal<>();
	
	public static void start() {
		t1.set(System.currentTimeMillis());
	}
	public static void finish(String methodName) {
		long finishTime = System.currentTimeMillis();
		System.out.println(methodName+"方法耗时"+(finishTime-t1.get())+"ms");
	}
}
