import java.io.File;

import javax.swing.JFileChooser;

public class ExceptionExample {
    public static void main(String[] args) {

    }
    public File getFile() {
        try{
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int response = chooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                getIntArray(file);
            }
        } catch (Exception) {
            System.out.println("Needs to be ints");
        }
    }
}