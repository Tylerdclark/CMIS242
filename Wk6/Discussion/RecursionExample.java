package Wk6.Discussion;

/**
* File Name: RecursionExample.java
* Author: Tyler D Clark
* Date: 17 Feb 2020
* Purpose: Demonstrates recursion by giving the sum of a number and the numbers less than it
 */
public class RecursionExample {
    public static void main(String[] args) {
        System.out.println(sumNum(10));
    }

    public static int sumNum(int n) {
        if ( n < 0) {
            System.out.print("This number will cause infinite recursion!: ");
            return n;
        // this if statement breaks out of the recursion    
        }if (n == 1) {
            return n;
        // the method itself is being called on the number sub one    
        }else {
            return (n + sumNum(n - 1));
        }
    }
}    