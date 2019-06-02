/**
 * 
 */
package 代理.动态代理例子;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author clgao
 *
 */
public class StuInvocationHandler<T> implements InvocationHandler {

	T target;
	/**
	 * 
	 */
	public StuInvocationHandler(T target) {
		this.target = target;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("代理执行"+method.getName()+"方法");
		MonitorUtil.start();
		Object result = method.invoke(target, args);
		MonitorUtil.finish(method.getName());
		return result;
	}

}

























