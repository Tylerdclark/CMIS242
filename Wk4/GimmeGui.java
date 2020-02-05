import javax.swing.*;
import java.awt.*;
public class GimmeGui extends JFrame {

    public GimmeGui () {
      this ("one");
    } // end no parameter constructor
  
    public GimmeGui (String t) {
        // next four lines are imperative
      setTitle (t);
      setSize (200,200);
      setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo (null);
      add (new JButton ("North " + t), BorderLayout.NORTH);
      add (new JButton ("East " + t), BorderLayout.EAST);
      add (new JButton ("West " + t), BorderLayout.WEST);
     
      validate (); // check that everything makes sense
      pack (); // pack it within the visible screen
      setVisible (true); // make it visable
    } // end String constructor
  
    public static void main (String args []) {
        GimmeGui ga = new GimmeGui ();
        GimmeGui gb = new GimmeGui ("two");
    } // end main
  
  } // end class GuiExample