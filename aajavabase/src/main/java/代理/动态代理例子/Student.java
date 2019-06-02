/**
 * 
 */
package 代理.动态代理例子;

/**
 * @author clgao
 *
 */
public class Student implements Person {

	private String name;
	public Student(String name) {
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see 代理.动态代理例子.Person#giveMoney()
	 */
	@Override
	public void giveMoney() {
	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+"上交班费50元");
	}

}
