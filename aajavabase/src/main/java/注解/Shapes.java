package 注解;

import java.util.Enumeration;
import java.util.Vector;

public class Shapes{
	public static void main(String [] args) {
		Vector s = new Vector<>();
		s.addElement(new Circle());
		s.addElement(new Square());
		Enumeration e = s.elements();
		while(e.hasMoreElements()) {
			((Shape)e.nextElement()).draw();
		}

	}
}