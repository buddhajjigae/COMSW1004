/**
 * @author: Alex Yu
 * @uni: ajy2116
 * @description: Human player class for the nim game
 * @date: 3/3/18
 */

import java.util.Scanner;

public class Human {

    // Declarations
    private int choice;
    private Scanner input;

    // Constructor
    public Human() {
        input = new Scanner(System.in);
        choice = -1;
    }

    // Human valid move method
    public void move(int marblesLeft) {
        // Determines when the turn is over
        boolean valid = false;
        System.out.println("There are " + marblesLeft + " marbles remaining.");
        while (valid == false) {
            System.out.println("How many marbles do you want to take: ");
            choice = input.nextInt();
            // Takes a choice that is at least 1 and at most, half the marbles
            if (choice >= 1 && marblesLeft / 2 >= choice) {
                System.out.println("You have taken: " + choice + " marbles.");
                valid = true;
            } else {
                System.out.println("Invalid input! Please try again.");
            }
        }
    }

    // Returns the humans move method
    public int getChoice() {
        return choice;
    }

} // End class