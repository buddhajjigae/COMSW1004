/**
 * A tester for the CreditCard class.
 * 
 * @author Cannon 
 *
 */

import java.util.Scanner;


public class CreditCardTester {

    public static void main(String[] args) {

        System.out.println("Please enter an 12-digit number.");
    	Scanner scanner = new Scanner(System.in);
    	String creditCardNumber = scanner.next();

    	CreditCard card = new CreditCard(creditCardNumber);
	    card.check();
	
	    if (card.isValid()) {
	        System.out.println("Valid");
	    } 
	    else {
	        int code = card.getErrorCode();
	        System.out.println("Oops! That's an invalid number.");
	        System.out.println("The error code was: " + code); 
	   }

    }
}
