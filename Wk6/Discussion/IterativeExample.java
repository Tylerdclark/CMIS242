/**
* File Name: IterativeExample.java
* Author: Tyler D Clark
* Date: 17 Feb 2020
* Purpose: An iterative version of RecursionExample, where a number and all of the numbers 
* below it are added up.
 */
public class IterativeExample {
    public static void main(String[] args) {
        System.out.println(sumNum(10));
    }

    public static int sumNum(int n) {
        int total = 0;
        for (int i = n; i > 0; i--){
            total += i;
        }
        return total;
    }
}