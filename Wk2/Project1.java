import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;

class Project1{
    
    
    
    public static void main(String[] args) throws IOException {
        List<Weight> userWeights = new ArrayList<Weight>();
        File file;
        Scanner filein;
        int response;
        JFileChooser chooser = new JFileChooser(".");
        
        //only files and directories
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        response = chooser.showOpenDialog(null);

        if(response == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            //Inside try catch for errors
            try {
                filein = new Scanner(file);
                if(file.isFile()){
                    int lines = 0;
                    while(filein.hasNextLine()){
                        //make the constructor better before continuing here
                        lines++;

                        if (lines > 25) {
                            break;
                        }
                        System.out.println(lines);


                    }
                } else {
                    System.out.println("That's not a file.");
                }
                filein.close();
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }    
}