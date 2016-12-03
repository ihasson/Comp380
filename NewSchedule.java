/**
 * Class: NewSchedule
 * 
 * Author: Brandon Garcia
 */
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 * Class that contains the schedule generated by the AI algorithm
 * Not created until AI algorithm is run
 * 
 */
public class NewSchedule extends JFrame {
	static String[] columns = {"Class", "Time"}; //Hardcoded until getters from Student class are implemented
	static String[][] data = {{"New Class 1", "12:00"}, {"New Class 2", "2:00"},
			{"New Class 3", "4:00"},{"New Class 4", "6:00"}};	
	JTable t = new JTable(data,columns);
	public NewSchedule() {
		add(t);
		setSize(250,250);	//Dimensions of new window frame
	}

}