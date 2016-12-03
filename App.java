/**
 * Class: App
 * 
 * Author: Brandon Garcia
 */
import javax.swing.SwingUtilities;

/**
 * 
 * The class that holds the UI and also opens the initial window
 *
 */
public class App {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				new MainFrame();	
							}
			
		});
		
		;
	}

}
