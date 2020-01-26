import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;

class Project1{
    
    
    
    public static void main(String[] args) throws IOException {
        
        //Initialization of a bunch of stuff I need
        List<Weight> userWeights = new ArrayList<Weight>();
        File file;
        Scanner filein;
        int response;
        JFileChooser chooser = new JFileChooser(".");
        
        //only files and directories
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        response = chooser.showOpenDialog(null);

        /* a ton of conditionals, it hurts my eyes. If I did not have to follow a 
        ** rubric, I would put the JFileChooser in a method... getFile() maybe?
        */
        if(response == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            //Inside try catch for errors
            try {
                filein = new Scanner(file);
                if(file.isFile()){
                    int lines = 0;
                    while(filein.hasNextLine()){
                    
                        lines++;
                        //making a weight object for every value and then adding to arraylist
                        Weight w = new Weight(filein.nextDouble());
                        userWeights.add(w);
                        // maximum of 25 weights
                        if (lines > 25) {
                            break;
                        } //end if
                    } //end while
                } else {
                    System.out.println("That's not a file.");
                } // need to close scanner for resource leaks
                filein.close();
            //just prints the error if we get one    
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //putting the weights into an array from the array list to meet rubric specifications
        Weight[] weightArr = userWeights.toArray(new Weight[0]);

        /* printing the results from the class methods Weight class
        ** the Weight class toString method overrides the Object class toString
        */
        System.out.println("Minimum weight: "+findMinimum(weightArr));
        System.out.println("Maximum weight: "+findMaximum(weightArr));
        System.out.println("Average weight: "+findAverage(weightArr));
    }
    /* takes in the array of weight objects and loops through
    ** using the Weight class lessThan() to determine the smallest
    ** makes sense why we made it...
    */
    private static Weight findMinimum(Weight[] w){
        Weight minWeight = w[0];
        for (int i = 1; i < w.length; i++) {
            if(w[i].lessThan(minWeight)) {
                minWeight = w[i];
            }
        }
        return minWeight;
    }
    // Similar to findMinimum() except only if lessThan() is false
    private static Weight findMaximum(Weight[] w){
        Weight maxWeight = w[0];
        for (int i = 1; i < w.length; i++) {
            if(w[i].lessThan(maxWeight)==false) {
                maxWeight = w[i];
            }
        }
        return maxWeight;       
    }
    // using the other convenient Weight class methods to determine avg   
    private static Weight findAverage(Weight[] w){
        Weight totalWeight = w[0];
        for (int i = 1; i < w.length; i++) {
            w[i].addTo(totalWeight);
        }
        return totalWeight;
    } 
}