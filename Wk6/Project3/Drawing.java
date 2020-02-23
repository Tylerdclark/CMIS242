import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Drawing extends JPanel {

	/* An overridden paintComponent method that draws the current shape on the Graphics 
	 * object that is passed to it as a parameter. It should also draw the number of 
	 * shapes that have been created thus far in the upper left corner.*/
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
	}
	/* An overridden getPreferredSize method that specifies the dimensions of the drawing 
	 * panel as 200 pixels wide and 200 pixels high.*/
	
	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return super.getPreferredSize();
	}
}
