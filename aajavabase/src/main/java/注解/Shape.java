/**
 * 
 */
package 注解;

/**
 * @author clgao
 *
 */
interface Shape {

	void draw();
	
}
class Circle implements Shape{

	/* (non-Javadoc)
	 * @see 注解.Shape#draw()
	 */
	@Override
	public void draw() {
		
		System.out.println("Circle.draw()");
		
	}
	
}
class Square implements Shape{

	/* (non-Javadoc)
	 * @see 注解.Shape#draw()
	 */
	@Override
	public void draw() {
		System.out.println("Square.draw();");
	}
	
}





































