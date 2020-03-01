package wk4.discussion;

import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Windowception implements ActionListener {
	private JFrame myFrame;

	// put it in a method for aethstetics
	public Windowception() {
	myFrame = new JFrame("Windowception");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setSize(300, 100);
		// splitting it into two panels with box layout
		JPanel upperPanel = new JPanel();
		JPanel lowerPanel = new JPanel();
		// manage them with boxlayout
		BoxLayout upperPanelLayoutManager = new BoxLayout(upperPanel, BoxLayout.X_AXIS);
		upperPanel.setLayout(upperPanelLayoutManager);
		BoxLayout lowerPanelLayoutManager = new BoxLayout(lowerPanel, BoxLayout.X_AXIS);
		lowerPanel.setLayout(lowerPanelLayoutManager);
		// add them to a mainpanel before adding it to the frame
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(upperPanel, BorderLayout.NORTH);
		mainPanel.add(lowerPanel, BorderLayout.SOUTH);
		myFrame.add(mainPanel);
		// make a label
		JLabel label = new JLabel("Press the button to make another window");
		upperPanel.add(label);
		// make a button
		JButton newWindow = new JButton("New Window");
		newWindow.addActionListener(this);
		lowerPanel.add(newWindow);
	}
	public void actionPerformed(java.awt.event.ActionEvent e) {
		Windowception gimmeGui = new Windowception();
		gimmeGui.show();
	}
	// show method.. can run in background
	public void show() {
		int randIntx = ThreadLocalRandom.current().nextInt(1000);
		int randInty = ThreadLocalRandom.current().nextInt(1000);
		myFrame.setVisible(true);
		myFrame.setLocation(randIntx, randInty);
	}
	public static void main(String[] args) {
		Windowception gimmeGui = new Windowception();
		gimmeGui.show();
	}


}