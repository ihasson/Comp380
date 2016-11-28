import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudentInfo extends JPanel {
	
	public StudentInfo(String name, String id) {
		JLabel n = new JLabel(name);
		JLabel i = new JLabel(id);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(n);
		add(i);
		
	}

}
