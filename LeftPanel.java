/**
 * Class: LeftPanel
 * 
 * Author: Brandon Garcia
 */
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Class for the left side of the screen containing the student info and schedule
 * 
 *
 */
public class LeftPanel extends JPanel {
	JTextField sName;
	JTextField sID;
	UISchedule s;
	StudentInfo si; //Will pass in a student object
	
		public LeftPanel(Student stu) {
			si = new StudentInfo(stu);

			setLayout(new BorderLayout());
			s = new UISchedule(stu);
			add(s, BorderLayout.SOUTH);		
			add(si, BorderLayout.NORTH);

	}
}
