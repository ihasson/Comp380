import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	RightPanel r;
	public MainFrame() {
		super("Hello World");
		setLayout(new BorderLayout());		
		
		r = new RightPanel();
		
		add(r, BorderLayout.EAST);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 500);
		setVisible(true);
	}
	
}
