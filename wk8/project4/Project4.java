package wk8.project4;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Project4 extends JFrame {

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
					Project4 frame = new Project4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	
	}
	// Create the frame
	public Project4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Real Estate Database");
		setResizable(false);
		this.setSize(400, 275);
		setContentPane(mainPanel());
		this.validate();
		this.pack();	
	}
	
	// Content panel

	public JPanel mainPanel() {
		JPanel thisPanel = new JPanel();
		thisPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		thisPanel.setLayout(new GridLayout(0, 2));
		thisPanel.add(leftPanel());
		thisPanel.add(rightPanel());
		return thisPanel;
	}
	public JPanel leftPanel() {
		JPanel thisPanel = new JPanel();
		thisPanel.setLayout(new GridLayout(7, 1, 0, 0));
		thisPanel.add(transactionJLabel);
		thisPanel.add(addressJLabel);
		thisPanel.add(bedroomsJLabel);
		thisPanel.add(squareFootageJLabel);
		thisPanel.add(priceJLabel);
		thisPanel.add(processBtn);
		thisPanel.add(changeStatusBtn);
		return thisPanel;
	}
	
	public JPanel rightPanel() {
		JPanel thisPanel = new JPanel();
		thisPanel.setLayout(new GridLayout(7, 1, 0, 0));
		thisPanel.add(transactionField);
		thisPanel.add(addressField);
		thisPanel.add(bedroomsField);
		thisPanel.add(squareFootageField);
		thisPanel.add(priceField);
		thisPanel.add(processComboBox);
		thisPanel.add(statusComboBox);
		return thisPanel;
	}
}
