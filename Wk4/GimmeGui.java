import javax.swing.*;
import java.awt.*;


//note that it extends JFrame
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
      //adding the buttons
      //we can add anything that extends JComponent
      //add lets you add in a new component

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