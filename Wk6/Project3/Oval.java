
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Oval extends Shape {
	
	/* A constructor that accepts three parameters for the purpose of initializing the 
	 * characteristics of the shape, a Rectangle object that defines the dimensions and 
	 * position of the shape, the color of the shape and whether the shape is solid or 
	 * hollow*/
	
	private static final long serialVersionUID = 1L;

	public Oval(Rectangle dimensionsAndPosition, Color color, String sOrH) {
		super(dimensionsAndPosition, color, sOrH);

	}
	
	/* An overridden method draw that draws the Oval object on the Graphics object 
	 * passed as a parameter.*/
	
	@Override
	void draw(Graphics g) {
		g.drawOval(super.x, super.y, super.width, super.height);
	}

}
