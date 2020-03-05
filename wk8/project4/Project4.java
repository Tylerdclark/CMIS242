package wk8.project4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Project4 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private TreeMap<Integer, Property> propertyTreeMap = new TreeMap<>();
	
	// JLabels
	private JLabel transactionJLabel = new JLabel("Transaction No:");
	private JLabel addressJLabel = new JLabel("Address:");
	private JLabel bedroomsJLabel = new JLabel("Bedrooms:");
	private JLabel squareFootageJLabel = new JLabel("Square Footage:");
	private JLabel priceJLabel = new JLabel("Price:");
	
	// JTextFields
	private JTextField transactionField = new JTextField();
	private JTextField addressField = new JTextField();
	private JTextField bedroomsField = new JTextField();
	private JTextField squareFootageField = new JTextField();
	private JTextField priceField = new JTextField();
	
	// JButtons 
	private JButton processBtn = new JButton("Process");
	private JButton changeStatusBtn = new JButton("Change Status");
	
	// JComboboxes
	private String[] processeStrings = {"Insert", "Delete", "Find"};
	private JComboBox<String> processComboBox = new JComboBox<>(processeStrings);
	private JComboBox<Status> statusComboBox = new JComboBox<>(Status.values());
	
	// Main here
	public static void main(String[] args) {
		
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
	private JPanel mainPanel() {
		JPanel thisPanel = new JPanel();
		thisPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		thisPanel.setLayout(new GridLayout(0, 2));
		thisPanel.add(leftPanel());
		thisPanel.add(rightPanel());
		return thisPanel;
	}
	// split into left
	private JPanel leftPanel() {
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
		changeStatusBtn.addActionListener(this);
		return thisPanel;
	}
	// and right panel
	private JPanel rightPanel() {
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
	// one action performed which will call other methods based on user input
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			
			if (e.getSource() == processBtn) {
				if (processComboBox.getSelectedItem() == "Insert") {
					insertProperty();
				} 
				else if(processComboBox.getSelectedItem() == "Delete") {
					deleteProperty();
				} 
				else if (processComboBox.getSelectedItem() == "Find") {
					findProperty();
				}
			} else if (e.getSource() == changeStatusBtn) {
				changeStatus();
			}
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(getParent(), "Please use integers for "
					+ "Transaction Number, Bedrooms, Square Footage, and Price");
		}
		
	}
	//use treemap's built in methods to insert, delete and find
	private void insertProperty() {
		int trans = Integer.parseInt(transactionField.getText());
		if (!propertyTreeMap.containsKey(trans)) {
			Property insertedProperty = new Property(
					addressField.getText(), 
					Integer.parseInt(bedroomsField.getText()), 
					Integer.parseInt(squareFootageField.getText()), 
					Integer.parseInt(priceField.getText()));
			propertyTreeMap.put(trans, insertedProperty);
			JOptionPane.showMessageDialog(getParent(), insertedProperty.toString() 
					+ "\n<html><b>Added!</b></html>");
		} else {
			JOptionPane.showMessageDialog(getParent(), "Transaction number used.");
		}
	}
	private void deleteProperty() {
		int trans = Integer.parseInt(transactionField.getText());
		if (propertyTreeMap.containsKey(trans)) {
			Property propertyDeleted = propertyTreeMap.get(trans);
			propertyTreeMap.remove(trans);
			JOptionPane.showMessageDialog(getParent(), propertyDeleted.toString() 
					+ "\n<html><b>Deleted!</b></html>");
		
		}else {
			doesNotExist();
		}
	}	
	private void findProperty() {
		int trans = Integer.parseInt(transactionField.getText());
		if (propertyTreeMap.containsKey(trans)) {
			Property tempProperty = propertyTreeMap.get(trans);
			JOptionPane.showMessageDialog(getParent(),tempProperty.toString());
		}else {
			doesNotExist();
		}
		
	}
	//change the status by copying property and replacing it with changed status one
	private void changeStatus() {
		int trans = Integer.parseInt(transactionField.getText());
		if (propertyTreeMap.containsKey(trans)) {
			Status changedStatus = (Status)statusComboBox.getSelectedItem();
			Property tempProperty = propertyTreeMap.get(trans);
			tempProperty.changeState(changedStatus);
			propertyTreeMap.replace(trans, tempProperty);
			JOptionPane.showMessageDialog(getParent(), tempProperty.toString() 
					+ "\n<html><b>Updated!</b></html>");
		}else {
			doesNotExist();
		}

	}
	//was using this a lot
	private void doesNotExist() {
		JOptionPane.showMessageDialog(getParent(), "Property does not exist.");
	}
	
}
