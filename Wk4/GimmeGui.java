import javax.swing.JFrame;

public class GimmeGui {

  private JFrame myFrame;

  //put it in a method for aethstetics
  public GimmeGui(){
    myFrame = new JFrame("This is my title");
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.setSize(300, 300);
  }
  //show method.. can run in background
  public void show(){
    myFrame.setVisible(true);
  }
  public static void main(String[] args) {
  GimmeGui gimmeGui = new GimmeGui();
  gimmeGui.show();
  }
}