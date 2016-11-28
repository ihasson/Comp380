import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LeftPanel extends JPanel {
	JTextField sName;
	JTextField sID;
	Schedule s;
	StudentInfo si = new StudentInfo("Last, First", "000000000");
		public LeftPanel() {
		setLayout(new BorderLayout());
		s = new Schedule();
		add(s, BorderLayout.CENTER);		
		add(si, BorderLayout.NORTH);

	}
}
