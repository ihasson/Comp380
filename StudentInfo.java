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
	
	public StudentInfo(String name, String id) { //Will receive a student object
		JLabel n = new JLabel(name + "\n");
		JLabel i = new JLabel(id);
		JLabel y = new JLabel("Month, Year Admitted");
		JLabel m = new JLabel("Major");
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
