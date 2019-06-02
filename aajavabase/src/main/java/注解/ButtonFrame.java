/**
 * 
 */
package 注解;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author clgao
 *
 */
public class ButtonFrame extends JFrame{

	private static final int width = 300;
	private static final int height = 200;
	private JPanel panel;
	private JButton yellowButton;
	private JButton blueButton;
	private JButton redButton;
	/**
	 * 构造器
	 */
	public ButtonFrame() {
		setSize(width,height);
		panel = new JPanel();
		add(panel);
		yellowButton = new JButton("Yellow");
		blueButton = new JButton("Blue");
		redButton = new JButton("Red");
		panel.add(yellowButton);
		panel.add(blueButton);
		panel.add(redButton);
		ActionListenerInstaller.processAnnotations(this);
		
	}
	@ActionListenerFor(source="yellowButton")
	public void yellowBackground() {
		panel.setBackground(Color.YELLOW);
	}
	@ActionListenerFor(source="blueButton")
	public void blueBackground() {
		panel.setBackground(Color.BLUE);
	}
	@ActionListenerFor(source = "redButton")
	public void redBackground() {
		panel.setBackground(Color.RED);
	}
}
































