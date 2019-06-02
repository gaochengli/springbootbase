/**
 * 
 */
package 代理;

/**
 * @author clgao
 *
 */
public class RealSubject implements Subject{
	/* (non-Javadoc)
	 * @see 代理.Subject#request()
	 */
	@Override
	public void request() {
		
		System.err.println("来自于真正的Subject");
		
	}
}
