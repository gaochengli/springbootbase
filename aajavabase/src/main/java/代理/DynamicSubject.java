/**
 * 
 */
package 代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author clgao
 *
 */
public class DynamicSubject implements InvocationHandler{

	private Object obj;//接收任意类型的对象
	
	/**
	 * 
	 */
	public DynamicSubject() {
		// TODO Auto-generated constructor stub
	}
	public DynamicSubject(Object obj) {
		this.obj = obj;
	}
	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		obj.getClass();
		System.out.println("调用之前"+method);
		method.invoke(obj, args);
		System.out.println("调用之后"+method);
		return null;
	}

	
	
}
