import java.awt.BorderLayout;

import javax.swing.JPanel;
	
public class RightPanel extends JPanel {
	Options rightOp;
	
	public RightPanel() {
		setLayout(new BorderLayout());
		rightOp = new Options();
		add(rightOp, BorderLayout.SOUTH);
	}

}
