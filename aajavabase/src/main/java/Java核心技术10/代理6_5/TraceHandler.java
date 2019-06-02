package Java核心技术10.代理6_5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TraceHandler implements InvocationHandler{

	private Object target;
	
	public TraceHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//打印方法名
		System.out.println(method.getName());
		return method.invoke(target, args);
	}
	
	public static void main(String[] args) {
		Object [] elements = new Object[1000];
		Object proxy = Proxy.newProxyInstance(null, new Class[] {Comparable.class}, new TraceHandler(1));
		
	}
	
	

}
