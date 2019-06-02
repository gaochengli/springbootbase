/**
 * 
 */
package 反射;

import java.util.Random;

/**
 * @author clgao
 * 通过路径加载类，产生一个实例
 */
public class NewInstanceDemo {
    static final int BRIDGE    = 0x00000040;
    static final int VARARGS   = 0x00000080;
    static final int SYNTHETIC = 0x00001000;
    static final int ANNOTATION  = 0x00002000;
    static final int ENUM      = 0x00004000;
    static final int MANDATED  = 0x00008000;
	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	
		System.out.println(ENUM);
		System.out.println(MANDATED);
		String s = "java.util.Random";
		Object o = Class.forName(s).newInstance();
		System.out.println(o.toString());
		System.out.println(((Random)o).nextInt(100));
		
	}

}
