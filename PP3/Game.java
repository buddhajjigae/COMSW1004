/**
 * @author: Alex Yu
 * @uni: ajy2116
 * @description: Runs the nim game after being called by the nim class
 * @date: 3/3/18
 */

import java.util.Random;

public class Game {
      
    // Declarations
    private int marbles;
    private int mode;
    private int turn;
    private Computer computerPlayer;
    private Human humanPlayer;
    private Random random = new Random();

    // Constructor
    public Game() {
        // Generates random int between 10 and 100
        marbles = random.nextInt(100 + 1 - 10) + 10;
        // Determines who goes first
        turn = random.nextInt(2);
        // Determines Computer mode, 0 is smart and 1 is stupid
        mode = random.nextInt(2);
        if (mode == 0) {
            System.out.println("**Computer is in smart mode**");
        } else {
            System.out.println("**Computer is in stupid mode**");
        }
        computerPlayer = new Computer(mode);
        humanPlayer = new Human();
    }

    // Plays the game based on who gets the first turn
    public void play() {
        while (marbles > 1) {
            // Computer goes first if 0 for turn
            if (turn == 0) {
                computerPlayer.move(marbles);
                // Remaining marbles after computer move
                marbles = marbles - computerPlayer.getChoice();
                turn = 1;
                // Player goes first if 1 for turn   
            } else if (turn == 1) {
                humanPlayer.move(marbles);
                // Remaining marbles after human move
                marbles = marbles - humanPlayer.getChoice();
                turn = 0;
            }
        }
        // Call victory method if 1 marble left
        if (marbles == 1) {
            victory();
        }
    }

    // Determines who wins based upon turn
    private void victory() {
        // Human wins if 1 marbles left on computer turn
        if (turn == 0) {
            System.out.println("Human wins!");
        // Computer wins if 1 marble left on human turn
        } else {
            System.out.println("Computer wins!");
        }
    }           
    
} // End class