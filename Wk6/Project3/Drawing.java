import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Drawing extends JPanel {
	
	Shape currentShape;
	
	private static final long serialVersionUID = 1L;

	/* An overridden paintComponent method that draws the current shape on the Graphics 
	 * object that is passed to it as a parameter. It should also draw the number of 
	 * shapes that have been created thus far in the upper left corner.*/
	

	@Override
	protected void paintComponent(Graphics g) {
		//currentShape.setColor(g);
		g.drawString(String.valueOf(Shape.getNoOfShapes()), 20, 25);
		if (currentShape instanceof Oval) {
			if (currentShape.getSolid()) {
				g.fillOval(currentShape.x, currentShape.y, currentShape.width, currentShape.height);	
			}
			if (!currentShape.getSolid()) {
				g.drawOval(currentShape.x, currentShape.y, currentShape.width, currentShape.height);

			}
		}
		if (currentShape instanceof Rectangular) {
			if (currentShape.getSolid()) {
				g.fillRect(currentShape.x, currentShape.y, currentShape.width, currentShape.height);

			}
			if (!currentShape.getSolid()) {
				g.drawRect(currentShape.x, currentShape.y, currentShape.width, currentShape.height);
			}
		}
	
	}
	/* An overridden getPreferredSize method that specifies the dimensions of the drawing 
	 * panel as 200 pixels wide and 200 pixels high.*/
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(200, 200);
	}
	
	/* An instance method named drawShape that is passed the current shape to be drawn. 
	 * It first checks whether the shape provided will completely fit within the panel. 
	 * If not, it throws an OutsideBounds exception. Otherwise, it saves the shape in 
	 * the corresponding instance variable. It then calls repaint to cause that shape 
	 * to be drawn.*/
	
	public void drawShape(Shape s) throws OutsideBounds {
		//this likely won't work, will fix later
		if (s.x + s.width > 200 || s.y + s.height > 200) {
			throw new OutsideBounds("Too big of a shape!");
		} else {
			this.currentShape = s;
			currentShape.setColor(getGraphics());
			repaint();
		}
		
	}
}
