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
	StudentInfo si = new StudentInfo("Last, First MI", "000000000"); //Will pass in a student object
	
		public LeftPanel() {
			Dimension dim = getPreferredSize();
			dim.width = 250;
			setPreferredSize(dim);
			setLayout(new BorderLayout());
			s = new UISchedule();
			add(s, BorderLayout.SOUTH);		
			add(si, BorderLayout.NORTH);

	}
}
