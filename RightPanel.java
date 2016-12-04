/**
 * Class: RightPanel
 * 
 * Author: Brandon Garcia
 */
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Class for the right side of window containing options and long term schedule image 	
 * 
 *
 */
public class RightPanel extends JPanel {
	Options rightOp;
	Graphics g;
	JLabel tree;
	public RightPanel() {
		setLayout(new BorderLayout());
		rightOp = new Options();
		add(rightOp, BorderLayout.SOUTH);
		BufferedImage img;
		try {
			img = ImageIO.read(getClass().getClassLoader().getResource("tree.png")); //Image MUST be resized manually
			tree= new JLabel(new ImageIcon(img));
			add(tree, BorderLayout.NORTH);
			tree.setVisible(false);
			
		} catch (IOException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		
		
		

	}

}
