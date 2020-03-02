package wk8.project4;


import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {

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
	
	/*	JButtons*/
	
	


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
		setBounds(100, 100, 425, 450);
		setResizable(false);
		setContentPane(mainPanel());
	}
	// Content panel
	public JPanel mainPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPanel.setLayout(new GridLayout(7, 2));
		return mainPanel;
		

		
		
	
	}
}
