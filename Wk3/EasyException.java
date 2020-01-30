import java.util.Scanner;

/**
 * This file shows the usage of the throws keywords and the usage 
 * of the try/catch block
 */

public class EasyException {

    private static int accountBalance;

    public static void main(String[] args){
        bank();
    }

    public static void bank() {
        int bankerHand;
        Scanner bankScanner = new Scanner();
        System.out.println("Welcome to the bank. Please hand me one cash note at a time");
        System.out.println("How many cash notes?");
        int loopCount = bankScanner.nextInt();

        for (int i = 0; 0 < loopCount; i++) {
            System.out.println("1, 2, 5, 10, 20, 50 or 100?");
            bankerHand = bankScanner.nextInt();
            bankTeller(bankerHand);
        }
        System.out.println("Bank balance is:" + getaccountBalance);

    }

    private static void bankTeller(int cash) throws cashException {
        switch (cash) {
            case 1: accountBalance++;
                break;
            case 2: accountBalance+=2;
                System.out.println("Oooh nice, rare");
                break;
            case 5: accountBalance+=5;
                break;
            case 10: accountBalance+=10;
                break;        
            case 20: accountBalance+=20;
                break;
            case 50: accountBalance+=50;
                break;
            case 100: accountBalance+=100;
                break;
            default: throw new cashException("thats not cash");
        }
    }
    public static int getaccountBalance() {
        return accountBalance;

    }


 } 