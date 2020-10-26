/**
 * @author: Alex Yu
 * @uni: ajy2116
 * @description: Credit card class that checks for number validity
 * @date: 3/3/18
 */

public class CreditCard {

    // Declarations
    private String num;
    private int errorcode;

    // Constructor
    public CreditCard(String creditCardNumber) {
        errorcode = 0;
        num = creditCardNumber;
    }

    // Runs all checks for error codes
    public void check() {
        if (check1() == false) {
            errorcode = 1;
        } else if (check2() == false) {
            errorcode = 2;
        } else if (check3() == false) {
            errorcode = 3;
        } else if (check4() == false) {
            errorcode = 4;
        } else if (check5() == false) {
            errorcode = 5;
        } else if (check6() == false) {
            errorcode = 6;
        }
    }

    // 1. 1st digit must be a 4
    private Boolean check1() {
        // Checks to see if 1st digit is 4
        if (num.charAt(0) != '4') {
            return false;
        } else {
            return true;
        }
    }

    // 2. 4th digit must be one greater than 5th digit
    private Boolean check2() {
        int digit4 = Integer.parseInt(Character.toString(num.charAt(3)));
        int digit5 = Integer.parseInt(Character.toString(num.charAt(4)));
        // Checks to see if 4th is grater than 5th by 1
        if (digit4 != (digit5 + 1)) {
            return false;
        } else {
            return true;
        }
    }

    // 3. Product of 1st, 5th, and 9th must be 24
    private Boolean check3() {
        int char1 = Integer.parseInt(num.substring(0, 1));
        int char5 = Integer.parseInt(num.substring(4, 5));
        int char9 = Integer.parseInt(num.substring(8, 9));
        // Checks to see if product is 24
        if (char1 * char5 * char9 != 24) {
            return false;
        } else {
            return true;
        }
    }

    // 4. Sum of all digits must be evenly divisible by 4
    private Boolean check4() {
        int sum = 0;
        for (int j = 0; j < num.length(); j++) {
            // Parse each digit into int in card number string and sum them
            sum += Integer.parseInt(Character.toString(num.charAt(j)));
        }
        // Checks to see if sum is divisble by 4
        if (sum % 4 != 0) {
            return false;
        } else {
            return true;
        }
    }

    // 5. Sum of first 4 digits must be one less than the sum of last 4 digits
    private Boolean check5() {
        int sum = 0;
        int sum2 = 0;
        // Parse first 4 digits into int in card number string and sum them
        for (int j = 0; j < 4; j++) {
            sum += Integer.parseInt(Character.toString(num.charAt(j)));
        }
        // Parse last 4 digits into int in card number string and sum them
        for (int j = 8; j < num.length(); j++) {
            sum2 += Integer.parseInt(Character.toString(num.charAt(j)));
        }
        // Checks to see if first 4 sum is one less than last 4 sum
        if (sum != sum2 - 1) {
            return false;
        } else {
            return true;
        }
    }

    // 6. Sum of first two and 7th and 8th 2-digit numbers must be 100  
    private Boolean check6() {
        int sum = 0;
        int sum2 = 0;
        // Convert 1st and 2nd digits into 2-digit number
        int digit1 = Integer.parseInt(Character.toString(num.charAt(0)));
        int digit2 = Integer.parseInt(Character.toString(num.charAt(1)));
        sum = digit1 * 10 + digit2;

        // Convert 7th and 8th digits into 2-digit number
        int digit7 = Integer.parseInt(Character.toString(num.charAt(6)));
        int digit8 = Integer.parseInt(Character.toString(num.charAt(7)));
        sum2 = digit7 * 10 + digit8;
        if (sum + sum2 != 100) {
            return false;
        } else {
            return true;
        }
    }

    // Checks to see if card number is valid
    public Boolean isValid() {
        if (errorcode == 0) {
            return true;
        } else {
            return false;
        }
    }

    // Return error code method
    public int getErrorCode() {
        return errorcode;
    }

} // End class