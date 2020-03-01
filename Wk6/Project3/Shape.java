package wk6.project3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Shape extends Rectangle {

	private static final long serialVersionUID = 1L;
	private Color color;
	private shapeType solidOrHollow;
	
	public enum shapeType{
		Solid,
		Hollow;
	}
	
	private static int shapeCount;
	
	/* A constructor that accepts three parameters for the purpose of initializing the 
	 * characteristics of the shape, a Rectangle object that defines the dimensions and 
	 * position of the shape, the color of the shape and whether the shape is solid or 
	 * hollow. It should also update the number of shapes created so far.*/
	
	public Shape (Rectangle dimensionsAndPosition, Color color, String sOrH) {
		super(dimensionsAndPosition);
		this.color = color;
		this.solidOrHollow = shapeType.valueOf(sOrH);
		shapeCount++;
	}
	
	/* An instance method named setColor that accepts the Graphics object as a parameter 
	 * and sets the color for the next draw operation to the color of the current shape.*/
	
	public void setColor(Graphics g) {
		g.setColor(this.color);
		System.out.println(g.toString());
		
	}
	
	/* An instance method named getSolid that returns whether the shape is solid or 
	 * hollow.*/
	public boolean getSolid() {
		if (this.solidOrHollow == shapeType.Solid) {
			return true;
		} 
		else if (this.solidOrHollow == shapeType.Hollow) {
			return false;
		} else {
			System.out.println("Problem with solid or hollow");
			return false;
		}
	}
	
	/* A class method named getNoOfShapes that returns the number of shapes created 
	 * so far.*/
	
	public static int getNoOfShapes () {
		return shapeCount;
	}
	
	/* An abstract method named draw that accepts a Graphics object as a parameter.*/
	
	abstract void draw (Graphics g);
	
}
