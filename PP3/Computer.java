/**
 * @author: Alex Yu
 * @uni: ajy2116
 * @description: Computer player class for the nim game
 * @date: 3/3/18
 */

import java.util.Random;

public class Computer {

    // Declarations
    private int mode;
    private int choice;
    private Random random = new Random();

    // Constructor
    public Computer(int m) {
        mode = m;
        choice = -1;
    }

    // Computer move method
    public void move(int marblesLeft) {
        System.out.println("There are " + marblesLeft + " marbles remaining.");
        // Computer stupid mode move
        if (mode == 1) {
            choice = random.nextInt((marblesLeft) / 2) + 1;
            // Computer smart mode move
        } else if (mode == 0) {
            int i = 64;
            boolean valid = true;
            while (i > 1 && valid == true) {
                // Random stupid legal move if marbles = 3, 7, 15, 31, or 63
                if (marblesLeft == i - 1) {
                    choice = random.nextInt((marblesLeft) / 2) + 1;
                    valid = false;
                    // Computer makes marble size a power of 2-1 if legal
                } else if (marblesLeft > i - 1) {
                    choice = marblesLeft - (i - 1);
                    valid = false;
                    // Goes to the next lower power of 2
                } else {
                    i = i / 2;
                }
            }
        }
        System.out.println("Computer has taken: " + choice + " marbles.");
    }

    // Returns computer move method
    public int getChoice() {
        return choice;
    }

}// End class