package wk8.project4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Project4 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private TreeMap<Integer, Property> properTreeMap = new TreeMap<>();
	
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
		
		Property property = new Property("", 1, 1, 1);
		System.out.println(property);
		property.changeState(Status.UNDER_CONTRACT);
		System.out.println(property);
		Project4 frame = new Project4();
		frame.setVisible(true);

	
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
	// split into left
	public JPanel leftPanel() {
		JPanel thisPanel = new JPanel();
		thisPanel.setLayout(new GridLayout(7, 1, 0, 0));
		thisPanel.add(transactionJLabel);
		thisPanel.add(addressJLabel);
		thisPanel.add(bedroomsJLabel);
		thisPanel.add(squareFootageJLabel);
		thisPanel.add(priceJLabel);
		thisPanel.add(processBtn);
		processBtn.addActionListener(this);
		thisPanel.add(changeStatusBtn);
		return thisPanel;
	}
	// and right panel
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == processBtn) {
				if (processComboBox.getSelectedItem() == "Insert") {
					insertProperty();
				} else if(processComboBox.getSelectedItem() == "Delete") {
					
				} else if (processComboBox.getSelectedItem() == "Find") {
					
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
	
	private void insertProperty() {
		int trans = Integer.parseInt(transactionField.getText());
		Property insertedProperty = new Property(
				addressField.getText(), 
				Integer.parseInt(bedroomsField.getText()), 
				Integer.parseInt(squareFootageField.getText()), 
				Integer.parseInt(priceField.getText()));
		properTreeMap.put(trans, insertedProperty);
		
	}
	
}
