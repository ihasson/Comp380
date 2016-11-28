import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	RightPanel r;
	LeftPanel l;
	public MainFrame() {
		super("AI");
		setLayout(new BorderLayout());		
		
		r = new RightPanel();
		l = new LeftPanel();
		
		add(r, BorderLayout.EAST);
		add(l, BorderLayout.WEST);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 500);
		setVisible(true);
	}
	
}
