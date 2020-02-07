import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SuperSimpleUI implements ActionListener {
    private JFrame frame;
    private JLabel label;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JButton button;
    private JTextField textField;
    private JTextArea result;
    int total = 0;

    public SuperSimpleUI() {
        //new frame and let it close
        frame = new JFrame("Total");
        //grid layout with 3 rows
        frame.setLayout(new GridLayout(3,0));
        //overall frame size
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //create panels and give borders
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //add them to the frame
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        //create the components and split them up among the panels
        label = new JLabel("Add a number to the total");
        textField = new JTextField(3);
        button = new JButton("Add to total");
        result = new JTextArea("Total ");
        result.setEditable(false);
        button.addActionListener(this);
        panel1.add(label);
        panel2.add(textField);
        panel2.add(button);
        panel3.add(result);
    }
    //make a run method to be cool
    public void run(){
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //show an option pane when exceptions
        try{
            String text = textField.getText();
            int addAmount = Integer.parseInt(text);
            total = total + addAmount;
            result.setText("Total = "+ total);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "You can't add that, silly", "Error", JOptionPane.WARNING_MESSAGE);
        }

    }
    public static void main(String[] args) {
        SuperSimpleUI GUI = new SuperSimpleUI();
        GUI.run();
    }
}