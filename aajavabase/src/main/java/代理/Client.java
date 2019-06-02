/**
 * 
 */
package 代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author clgao
 *
 */
public class Client {

	public static void main(String[] args) {
		Subject rs = new RealSubject();
		InvocationHandler ds = new DynamicSubject(rs);
		Class<?> cls = rs.getClass();
		Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ds);
		subject.request();
//		rs.request();
	}
	
}
