/**
 * Class: Mainframe
 * 
 * Author: Brandon Garcia
 * 
 */
import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * Main controller class/frame for the user interface
 * Holds a left and right panel for adding panel containers
 *
 */

public class MainFrame extends JFrame {
	RightPanel r;
	LeftPanel l;
	public MainFrame() {
		super("AI" + "\u00B2"); //Unicode superscript 2
		setLayout(new BorderLayout());		
		
		r = new RightPanel();	//Right side of screen
		l = new LeftPanel();	//Left side of screen
		
		add(r, BorderLayout.EAST);
		add(l, BorderLayout.WEST);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);	//Dimensions of initial window frame
		setVisible(true);
	}
	
}
