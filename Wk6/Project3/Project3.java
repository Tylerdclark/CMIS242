

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.*;


public class Project3 extends JFrame {

	private static final long serialVersionUID = 1L;

	public Project3() {

        setTitle("Geometric Drawing");
        setSize(420, 230);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // main panel

        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(500, 250));
        mainPanel.setVisible(true);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        this.add(mainPanel);
        
        // top panel
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(400, 200));
        topPanel.setVisible(true);
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        mainPanel.add(topPanel);
        
        // bottom panel
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(200, 25));
        bottomPanel.setVisible(true);
        bottomPanel.setLayout(new FlowLayout());
        mainPanel.add(bottomPanel);
        JButton drawButton = new JButton("Draw");
       
        
        bottomPanel.add(drawButton);
        
        // left top panel
        
        JPanel leftTopPanel = new JPanel(new GridLayout(7, 2));
        JLabel shapeTypeJLabel = new JLabel("Shape Type");
        String[] shapeList = {"Rectangle", "Oval"};
        JComboBox<String> shapeTypeListBox = new JComboBox<String>(shapeList);
        JLabel fillTypeJLabel = new JLabel("Fill Type");
        String[] fillList = {"Solid", "Hollow"};
        JComboBox<String> fillTypeListBox = new JComboBox<String>(fillList);
        JLabel colorJLabel = new JLabel("Color");
        String[] colorList = {"Black", "Red", "Orange", "Yellow", "Green", "Blue", "Magenta" };
        JComboBox<String> colorListBox = new JComboBox<String>(colorList);
        JLabel widthJLabel = new JLabel("Width");     
        JTextField widthField = new JTextField();        
        JLabel heightJLabel = new JLabel("Height");       
        JTextField heightField = new JTextField();  
        JLabel xJLabel = new JLabel("X Coordinate");
        JTextField xField = new JTextField();
        JLabel yJLabel = new JLabel("Y Coordinate");
        JTextField yField = new JTextField();
        
        
        
        leftTopPanel.setPreferredSize(new Dimension(200, 200));
        leftTopPanel.setVisible(true);
        leftTopPanel.add(shapeTypeJLabel);
        leftTopPanel.add(shapeTypeListBox);
		leftTopPanel.add(fillTypeJLabel);
		leftTopPanel.add(fillTypeListBox);
		leftTopPanel.add(colorJLabel);
		leftTopPanel.add(colorListBox);
		leftTopPanel.add(widthJLabel);
		leftTopPanel.add(widthField);
		leftTopPanel.add(heightJLabel);
		leftTopPanel.add(heightField);
		leftTopPanel.add(xJLabel);
		leftTopPanel.add(xField);
		leftTopPanel.add(yJLabel);
		leftTopPanel.add(yField);
        topPanel.add(leftTopPanel);
        
        // right top panel
        
        Drawing rightTopPanel = new Drawing();
        rightTopPanel.setPreferredSize(new Dimension(200, 200));
        rightTopPanel.setBorder(BorderFactory.createTitledBorder("Shape Drawing"));
        rightTopPanel.setVisible(true);
        rightTopPanel.setLayout(new FlowLayout());
        topPanel.add(rightTopPanel);
        
        drawButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int tempWidth = Integer.parseInt(widthField.getText());
					int tempHeight = Integer.parseInt(heightField.getText());
					int tempX = Integer.parseInt(xField.getText());
					int tempY = Integer.parseInt(yField.getText());
					
					Rectangle tempRectangle = new Rectangle(tempX, tempY, tempWidth, tempHeight);
					
					Color tempColor = stringColor(String.valueOf(colorListBox.getSelectedItem()));
					String tempFillType = (String) fillTypeListBox.getSelectedItem();
					String tempShapeType = (String) shapeTypeListBox.getSelectedItem();
					
					
					if (tempShapeType.equals("Rectangle") ) {
						
						Shape tempShape = new Rectangular(tempRectangle, tempColor, tempFillType);
						try {
							rightTopPanel.drawShape(tempShape);
						} catch (OutsideBounds e1) {
							JOptionPane.showMessageDialog(getParent(), e1.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
						}
						
					} 
					if (tempShapeType.equals("Oval")) {
						
						Oval tempShape = new Oval(tempRectangle, tempColor, tempFillType);
						try {
							rightTopPanel.drawShape(tempShape);
						} catch (OutsideBounds e1) {
							JOptionPane.showMessageDialog(getParent(), e1.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
						}
					}
				} catch (NumberFormatException nfException) {
					JOptionPane.showMessageDialog(getParent(), "Must be an Integer", "Error", JOptionPane.WARNING_MESSAGE);
				}


			}
		});
        
        this.pack();
    }
	// with help of this SO comment: https://stackoverflow.com/a/2854058
	public Color stringColor (String s) {
		
		String lowerCase = s.toLowerCase();
		
		Color color;
		try {
		    Field field = Class.forName("java.awt.Color").getField(lowerCase);
		    color = (Color)field.get(null);
		} catch (Exception e) {
		    color = null; // Not defined
		}
		return color;
	}
	
    public static void main(final String[] args) {
		
		new Project3();
	}

}