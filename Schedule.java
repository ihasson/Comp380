import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTable;

public class Schedule extends JPanel {
	String[] columns = {"Class", "Time"};
	String[][] data = {{"Class 1", "12:00"}, {"Class 2", "2:00"},
			{"Class 3", "4:00"},{"Class 4", "6:00"}};	
	JTable table = new JTable(data, columns);
		
	public Schedule() {
		setLayout(new BorderLayout());
		add(table, BorderLayout.SOUTH);
	}

}
