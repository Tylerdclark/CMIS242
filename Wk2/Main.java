import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Main
{
    public static void main(String[] args) throws IOException
    {
       // Use file dialog to select file.
       JFileChooser chooser = new JFileChooser();
       int result = chooser.showOpenDialog(null);
       // This assumes user pressed Open
       // Get the file from the file 
       File file = chooser.getSelectedFile();
       // Open the file
       FileReader reader = new FileReader(file);

       // Use read, which returns an int
       int i = reader.read();
       while (i != -1)
       {
           // Convert to char and print
           char ch = (char)i;
           System.out.print(ch);
           // Get next  from read()
           i = reader.read();
       }
       // reader.close();
     }
}