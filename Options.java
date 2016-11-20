import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Options extends JPanel {
	private JButton genSchedule;
	private JButton view;
	private JButton exit;
	private JButton changeMajor;
	
	public Options() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		genSchedule = new JButton("Generate Schedule");
		view = new JButton("View Schedule");
		changeMajor = new JButton("Change Major");
		exit = new JButton("EXIT");
		
		genSchedule.setAlignmentX(CENTER_ALIGNMENT);
		view.setAlignmentX(CENTER_ALIGNMENT);
		changeMajor.setAlignmentX(CENTER_ALIGNMENT);
		exit.setAlignmentX(CENTER_ALIGNMENT);
		
		add(genSchedule);
		add(view);
		add(changeMajor);
		add(exit);
	}
	
}
