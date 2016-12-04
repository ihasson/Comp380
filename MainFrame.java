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
	Student st;
	public MainFrame() {			
		super("AI" + "\u00B2"); //Unicode superscript 2
		Student st = new Student("123456789", "Garcia", "Brandon", 'R');
		st.setStudentMonthOfAdmit("August");
		st.setStudentYearOfAdmit(2014);
		st.setStudentMajor(new Major("Computer Science"));
		setLayout(new BorderLayout());		
		
		r = new RightPanel();	//Right side of screen
		l = new LeftPanel(st);	//Left side of screen
		
		add(r, BorderLayout.EAST);
		add(l, BorderLayout.WEST);
		this.setResizable(false);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);	//Dimensions of initial window frame
		this.setVisible(true);
		//this.pack();
	}
	
}
