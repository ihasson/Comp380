/**
 * Class: StudentInfo
 * 
 * Author: Brandon Garcia
 */
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Class displaying the student's information
 * 
 *
 */
public class StudentInfo extends JPanel {
	
	public StudentInfo(Student s) { //Will receive a student object
		JLabel n = new JLabel(s.getFirstName() + " " + s.getLastName() +  ", "  + s.getMiddleInitial());
		JLabel i = new JLabel(s.getStudentId());
		JLabel y = new JLabel(s.getStudentMonthOfAdmit() + " " + s.getStudentYearOfAdmit());
		JLabel m = new JLabel(s.getStudentMajor().getName());
		Dimension dim = new Dimension();
		
		dim.height = 250;
		setPreferredSize(dim);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(n);
		add(i);
		add(m);
		add(y);
		
	}

}
