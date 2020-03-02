package wk8.project4;



import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GUI<Status> extends JFrame {

	private static final long serialVersionUID = 1L;
	
	
	
	/*	JLabels	*/
	JLabel transactionJLabel = new JLabel("Transaction No:");
	JLabel addressJLabel = new JLabel("Address:");
	JLabel bedroomsJLabel = new JLabel("Bedrooms:");
	JLabel squareFootageJLabel = new JLabel("Square Footage:");
	JLabel priceJLabel = new JLabel("Price:");
	
	/*	JTextFields	*/
	JTextField transactionField = new JTextField();
	JTextField addressField = new JTextField();
	JTextField bedroomsField = new JTextField();
	JTextField squareFootageField = new JTextField();
	JTextField priceField = new JTextField();
	
	/*	JButtons */
	JButton processBtn = new JButton("Process");
	JButton changeStatusBtn = new JButton("Change Status");
	
	/*	JComboboxes	*/
	String[] processeStrings = {"Insert", "Delete", "Find"};
	JComboBox<String> processComboBox = new JComboBox<>(processeStrings);
	JComboBox<Status> statusComboBox = new JComboBox<>();
	
	
	


	public static void main(String[] args) {

				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	
	}
	// Create the frame
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 325, 275);
		setResizable(false);
		setContentPane(mainPanel());
		
	}
	// Content panel
	// TODO: split into left and right panels with flow layouts
	public JPanel mainPanel() {
		JPanel thisPanel = new JPanel();
		thisPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		thisPanel.setLayout(new GridLayout(7, 2));
		thisPanel.add(transactionJLabel);
		thisPanel.add(transactionField);
		thisPanel.add(addressJLabel);
		thisPanel.add(addressField);
		thisPanel.add(bedroomsJLabel);
		thisPanel.add(bedroomsField);
		thisPanel.add(squareFootageJLabel);
		thisPanel.add(squareFootageField);
		thisPanel.add(priceJLabel);
		thisPanel.add(priceField);
		thisPanel.add(processBtn);
		thisPanel.add(processComboBox);
		thisPanel.add(changeStatusBtn);
		thisPanel.add(statusComboBox);
		
		
		return thisPanel;
		

		
		
	
	}
}
