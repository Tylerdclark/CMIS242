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
	JLabel transactionJLabel = new JLabel("Transaction No:");
	JLabel addressJLabel = new JLabel("Address:");
	JLabel bedroomsJLabel = new JLabel("Bedrooms:");
	JLabel squareFootageJLabel = new JLabel("Square Footage:");
	JLabel priceJLabel = new JLabel("Price:");
	
	// JTextFields
	JTextField transactionField = new JTextField();
	JTextField addressField = new JTextField();
	JTextField bedroomsField = new JTextField();
	JTextField squareFootageField = new JTextField();
	JTextField priceField = new JTextField();
	
	// JButtons 
	JButton processBtn = new JButton("Process");
	JButton changeStatusBtn = new JButton("Change Status");
	
	// JComboboxes
	String[] processeStrings = {"Insert", "Delete", "Find"};
	JComboBox<String> processComboBox = new JComboBox<>(processeStrings);
	JComboBox<Status> statusComboBox = new JComboBox<>(Status.values());
	
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
	// one action performed which will call other methods based on user input
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			int tempTransNo = Integer.parseInt(transactionField.getText());
			
			if (e.getSource() == processBtn) {
				if (processComboBox.getSelectedItem() == "Insert") {
					if (!propertyTreeMap.containsKey(tempTransNo)) {
					insertProperty();
					} else {
						JOptionPane.showMessageDialog(getParent(), "Transaction number used.");
					}
				} // end process property
				else if(processComboBox.getSelectedItem() == "Delete") {
					if (propertyTreeMap.containsKey(tempTransNo)) {
						deleteProperty();
					} else {
						JOptionPane.showMessageDialog(getParent(), "Property does not exist.");
					}
				} // end delete property
				else if (processComboBox.getSelectedItem() == "Find") {
					if (propertyTreeMap.containsKey(tempTransNo)) {
						findProperty();
					} else {
						JOptionPane.showMessageDialog(getParent(), "Property does not exist.");
					}
				}// end find property
			}
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(getParent(), "Please use integers for transaction number, "
					+ "bedrooms, square footage, and price");
		}
		
	}
	
	private void insertProperty() {
		int trans = Integer.parseInt(transactionField.getText());
		Property insertedProperty = new Property(
				addressField.getText(), 
				Integer.parseInt(bedroomsField.getText()), 
				Integer.parseInt(squareFootageField.getText()), 
				Integer.parseInt(priceField.getText()));
		propertyTreeMap.put(trans, insertedProperty);
		System.out.println(transactionField.getText() + " Added!");
	}
	private void deleteProperty() {
		propertyTreeMap.remove(Integer.parseInt(transactionField.getText()));
		System.out.println(transactionField.getText() + " Removed!");
	}
	private void findProperty() {
		if (propertyTreeMap.containsKey(Integer.parseInt(transactionField.getText()))) {
			Property temProperty = propertyTreeMap.get(Integer.parseInt(transactionField.getText()));
			JOptionPane.showMessageDialog(getParent(), temProperty.toString());
		
		} else {
			JOptionPane.showMessageDialog(getParent(), "That property does not exist! "
					+ "to insert it into the database, use Insert");
		}
	}
	
	
}
