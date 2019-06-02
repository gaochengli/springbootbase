/**
 * 
 */
package 代理.动态代理例子;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


/**
 * @author clgao
 *
 */
public class ProxyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person zs = new Student("张三");
		InvocationHandler sh = new StuInvocationHandler<Person>(zs);
		Person sp = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[] {Person.class}, sh);
		sp.giveMoney();
	}

}
