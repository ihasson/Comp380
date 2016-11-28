import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
	
public class RightPanel extends JPanel {
	Options rightOp;
	Graphics g;
	public RightPanel() {
		setLayout(new BorderLayout());
		rightOp = new Options();
		add(rightOp, BorderLayout.SOUTH);
		BufferedImage img;
		try {
			img = ImageIO.read(getClass().getClassLoader().getResource("tree.jpg"));
			JLabel tree= new JLabel(new ImageIcon(img));
			add(tree, BorderLayout.NORTH);
			
		} catch (IOException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		
		

	}

}
