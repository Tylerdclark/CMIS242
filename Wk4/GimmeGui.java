import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GimmeGui implements ActionListener {

  private JFrame myFrame;
  

  //put it in a method for aethstetics
  public GimmeGui(){
    myFrame = new JFrame("Windowception");
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.setSize(300, 300);

    //make a label
    JLabel label = new JLabel("Press the button to make another window");
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setVerticalAlignment(JLabel.NORTH);
    myFrame.add(label);

    JButton newWindow = new JButton("New Window");
    newWindow.addActionListener(this);
    myFrame.add(newWindow);
  }

  public void actionPerformed(java.awt.event.ActionEvent e) {
    GimmeGui gimmeGui = new GimmeGui();
    gimmeGui.show();
  }

  //show method.. can run in background
  public void show(){
    int randIntx = ThreadLocalRandom.current().nextInt(1000);
    int randInty = ThreadLocalRandom.current().nextInt(1000);
    myFrame.setVisible(true);
    myFrame.setLocation(randIntx, randInty);
  }
  public static void main(String[] args) {
  GimmeGui gimmeGui = new GimmeGui();
  gimmeGui.show();
  }


}