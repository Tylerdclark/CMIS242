

import java.awt.*;
import javax.swing.*;




/**
 * 
 */

/**
 * @author tylerclark
 *
 */

public class Project3 extends JFrame {

	public Project3() {

        setTitle("Geometric Drawing");
        setSize(420, 230);
        setVisible(true);
        //setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // main panel

        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(500, 230));
        mainPanel.setVisible(true);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setBackground(Color.RED);
        this.add(mainPanel);
        
        // top panel
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(400, 200));
        topPanel.setVisible(true);
        topPanel.setBackground(Color.BLUE);
        topPanel.setLayout(new FlowLayout());
        mainPanel.add(topPanel);
        
        // bottom panel
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(200, 25));
        bottomPanel.setVisible(true);
        bottomPanel.setBackground(Color.ORANGE);
        bottomPanel.setLayout(new FlowLayout());
        mainPanel.add(bottomPanel);
        
        JButton drawButton = new JButton("Draw");
        bottomPanel.add(drawButton);
        
        // left top panel
        
        JLabel shapetypeJLabel = new JLabel("Shape Type");
        JPanel leftTopPanel = new JPanel();
        
        leftTopPanel.setPreferredSize(new Dimension(200, 200));
        leftTopPanel.setVisible(true);
        leftTopPanel.setBackground(Color.GREEN);
        leftTopPanel.setLayout(new GridLayout(7, 2));
        leftTopPanel.add(shapetypeJLabel);
        topPanel.add(leftTopPanel);
        
        //TODO: add buttons and fields
        
        // right top panel
        
        JPanel rightTopPanel = new JPanel();
        rightTopPanel.setPreferredSize(new Dimension(200, 200));
        rightTopPanel.setVisible(true);
        rightTopPanel.setBackground(Color.YELLOW);
        rightTopPanel.setLayout(new FlowLayout());
        topPanel.add(rightTopPanel);
        
        this.pack();
    }
//    private JPanel leftPanel() {
//    	
//    }

    public static void main(final String[] args) {
		
		new Project3();
	}

}