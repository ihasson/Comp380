/**
 * Class: Options
 * 
 * Author: Brandon Garcia
 */
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Panel containing the options menu in bottom right of screen
 * 
 *
 */
public class Options extends JPanel implements ActionListener {
	private JButton genSchedule;
	private JButton view;
	private JButton exit;
	private JButton changeMajor;
	private NewSchedule n;
	private boolean algRan;	//checks whether or not algorithm for new schedule has been run
	public Options() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		genSchedule = new JButton("Generate Schedule");
		view = new JButton("View Schedule");
		changeMajor = new JButton("Change Major");
		exit = new JButton("EXIT");
				
		add(genSchedule);	//Buttons are added vertically
		add(view);
		add(changeMajor);
		add(exit);
		
		genSchedule.addActionListener(this);
		view.addActionListener(this);
		exit.addActionListener(this);		
	}	
	/**
	 * Receives button objects and performs actions based on which button is received
	 */
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		if(clicked == genSchedule) 
			generateSchedule();
		if(clicked == view) 
			viewSchedule();
		if(clicked == exit)
			exitProg();
	}
	/**
	 * Exits the program by retrieving parent until a JFrame is found
	 */
	private void exitProg() {
		Container frame = exit.getParent().getParent();
		do 
            frame = frame.getParent(); 
        while (!(frame instanceof JFrame));                                      
        ((JFrame) frame).dispose();
	}
	
	/**
	 *	Runs AI algorithm and opens a new window with newly generated schedule 
	 */
	private void generateSchedule() {			
		//TODO call AI to calculate algorithm
		n = new NewSchedule();
		algRan = true;
		n.setVisible(true);
}	
	/**
	 * Opens previously generated schedule
	 */
	private void viewSchedule() {
			if(algRan) {
				n.setVisible(true);
			}
			else JOptionPane.showMessageDialog(null, "Generate Schedule First!");
				
			
		}
}
	

