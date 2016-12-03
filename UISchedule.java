/**
 * Class: UISchedule
 * 
 * Author Brandon Garcia
 */
import java.awt.Dimension;

import javax.swing.JTable;
/**
 * Panel displaying student's current schedule
 * 
 *
 */
public class UISchedule extends JTable {
	static String[] columns = {"Class", "Time"};
	static String[][] data = {{"Class 1", "12:00"}, {"Class 2", "2:00"},
			{"Class 3", "4:00"},{"Class 4", "6:00"}};	
		Dimension dim = new Dimension();

	public UISchedule() { //Will receive a Student Object 
		super(data,columns);
	}

}
