/* 
* File Name: Project1.java
* Author: Tyler D Clark
* Date: 25 Jan 2020
* Purpose: Reads weights from a text file using JFileChooser and puts them into an array
* of Weight objects. Uses methods to find the smallest, largest, and average weight and
* prints them out.
*/
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;

class Project1{
    // Runs here
    public static void main(final String[] args) throws IOException {

        /*
         * Initialization of a bunch of stuff I need. I am only using an ArrayList
         * temporarily because of the .add method and no fixed size
         */
        final List<Weight> userWeights = new ArrayList<Weight>();
        File file;
        Scanner fileIn;
        int response;
        final JFileChooser chooser = new JFileChooser(".");

        // only files and directories
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        response = chooser.showOpenDialog(null);

        /*
         * a ton of conditionals, it hurts my eyes. If I did not have to follow a
         * rubric, I would put the JFileChooser in a method... getFile() maybe?
         */
        if (response == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            // Inside try catch for errors
            try {
                fileIn = new Scanner(file);
                if (file.isFile()) {
                    int lines = 0;
                    while (fileIn.hasNextLine()) {
                        lines++;
                        // making a weight object for every value and then adding to arraylist
                        final int tempLb = fileIn.nextInt();
                        final double temptOz = fileIn.nextDouble();
                        final Weight tempW = new Weight(tempLb, temptOz);
                        userWeights.add(tempW);
                        // maximum of 25 weights
                        if (lines > 25) {
                            System.err.println("This program only accepts 25 or less weights");
                            System.exit(0);
                        } // end if
                    } // end while
                } else {
                    System.out.println("That's not a file.");
                } // need to close scanner for resource leaks
                fileIn.close();
                // just prints the error if we get one
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }
        // putting the weights into an array from the array list to meet rubric
        // specifications
        final Weight[] weightArr = userWeights.toArray(new Weight[0]);

        /*
         * printing the results from the class methods Weight class the Weight class
         * toString method overrides the Object class toString
         */
        System.out.println("Minimum weight: " + findMinimum(weightArr));
        System.out.println("Maximum weight: " + findMaximum(weightArr));
        System.out.println("Average weight: " + findAverage(weightArr));
    }

    /*
     * takes in the array of weight objects and loops through using the Weight class
     * lessThan() to determine the smallest. Makes sense why we made it...
     */
    private static Weight findMinimum(final Weight[] w) {
        Weight minWeight = w[0];
        for (int i = 1; i < w.length; i++) {
            if (w[i].lessThan(minWeight)) {
                minWeight = w[i];
            }
        }
        return minWeight;
    }

    // Similar to findMinimum() except only if lessThan() is false
    private static Weight findMaximum(final Weight[] w) {
        Weight maxWeight = w[0];
        for (int i = 1; i < w.length; i++) {
            if (w[i].lessThan(maxWeight) == false) {
                maxWeight = w[i];
            }
        }
        return maxWeight;
    }

    // using the other convenient Weight class methods to determine avg
    private static Weight findAverage(final Weight[] w) {
        final Weight totalWeight = new Weight(0, 0);
        for (int i = 0; i < w.length; i++) {
            totalWeight.addTo(w[i]);;
        }
        totalWeight.divide(w.length);
        return totalWeight;
    } 
}