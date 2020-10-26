/**
 * @author: Alex Yu
 * @uni: ajy2116
 * @description: Game class that plays a poker game
 * @date: 3/31/18
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class Game {

    // Declarations
    private Player player;
    private Deck deck;
    private Scanner input;
    // To continue the game
    private boolean cont;

    // Constructor
    public Game(String[] testHand) {
        // This constructor is to help test your code
        // use the contents of testHand to
        // make a hand for the player
        // use the following encoding for cards
        // c = clubs
        // d = diamonds
        // h = hearts
        // s = spades
        // 1-13 correspond to ace - king
        // example: s1 = ace of spades
        // example: testhand = {s1, s13, s12, s11, s10} = royal flush

        ArrayList<Card> testCards = new ArrayList<Card>();
        // Adds given cards from args testHand
        for (String text : testHand) {
            testCards.add(new Card(text));
        }
        System.out.println("This is your hand: " + checkHand(testCards));
        // Prevents the game from playing
        cont = false;
    }

    // Initializes the game to play
    public Game() {
        player = new Player();
        deck = new Deck();
        input = new Scanner(System.in);
        cont = true;
        System.out.println("**Welcome to Video Poker**");
    }

    // Plays the game
    public void play() {
        while (cont) {
            deck.shuffle();
            // Clears a player's hand
            player.clearHand();
            // Deals 5 cards into the player's hand
            for (int i = 0; i < 5; i++) {
                player.addCard(deck.deal());
            }

            Collections.sort(player.getHand());
            System.out.println("Bankroll is: " + player.getBankroll());
            System.out.println("Please make a token bet between 1-5");

            // Obtains the player's bet
            int bet = input.nextInt();
            if (bet < 6 && bet <= player.getBankroll() && bet > 0) {
                System.out.println("This is your hand: " + player.getHand());
                player.bets(bet);
                System.out.println("*Bankroll is*: " + player.getBankroll());
                // Exchange cards
                exchange();
                // Update bankroll
                winnings(bet);

                // Bankrupt
                if (player.getBankroll() <= 0) {
                    System.out.println("Game over! You're Bankrupt!");
                    cont = false;
                }
                // Play again
                if (player.getBankroll() > 0) {
                    System.out.println("Do you want to play again, y/n?");
                    String playAgain = input.next();
                    if (playAgain.equals("n")) {
                        System.out.println("Smart decision! Goodbye!");
                        cont = false;
                    }
                }
            }
        }
    }

    // Checks the players hand to evaluate what hand they have
    private String checkHand(ArrayList<Card> hand) {
        Collections.sort(hand);
        System.out.println("This is your hand: " + hand);
        if (royalFlush(hand)) {
            return "Royal Flush";
        } else if (straightFlush(hand)) {
            return "Straight Flush";
        } else if (fourKind(hand)) {
            return "Four of a Kind";
        } else if (fullHouse(hand)) {
            return "Full House";
        } else if (flush(hand)) {
            return "Flush";
        } else if (straight(hand)) {
            return "Straight";
        } else if (threeKind(hand)) {
            return "Three of a Kind";
        } else if (twoPairs(hand)) {
            return "Two Pairs";
        } else if (onePair(hand)) {
            return "One Pair";
        } else {
            return "No pair, you win nothing :(";
        }
    }

    // Exchanges the cards
    private void exchange() {
        // Amount of cards to be exchanged
        int amount = 6;
        // To secure benevolent usage of exchange
        while (amount >= 6) {
            System.out.println("How many cards would you like to exchange? 0-5");
            amount = input.nextInt();
        }

        // Originalhand copy for exchange purposes
        ArrayList<Card> originalHand = new ArrayList<>(player.getHand());
        // Immediately checks hand if no cards to be exchanged
        if (amount == 0) {
        } else if (amount < 5) {
            // Obtains the index position of card(s) to be exchanged
            for (int i = 0; i < amount; i++) {
                System.out.println("Enter card number 1-5 to be exchanged:");
                int exchange = input.nextInt();
                // Removes card at entered index
                player.removeCard(originalHand.get(exchange - 1));
                // Adds card at entered index
                player.addCard(deck.deal());
            }
        // Immediately exchanges all cards in hand
        } else if (amount == 5) {
            for (int i = 0; i < amount; i++) {
                player.removeCard(originalHand.get(i));
                player.addCard(deck.deal());
            }
        }
        System.out.println(checkHand(player.getHand()));
    }

    // Winnings depending on hand evaluation
    private double winnings(int bet) {
        ArrayList<Card> hand = player.getHand();
        if (royalFlush(hand)) {
            player.winnings(bet * 250);
            System.out.println("You won: " + bet * 250 + " tokens!");
        } else if (straightFlush(hand)) {
            player.winnings(bet * 50);
            System.out.println("You won: " + bet * 50 + " tokens!");
        } else if (fourKind(hand)) {
            player.winnings(bet * 25);
            System.out.println("You won: " + bet * 25 + " tokens!");
        } else if (fullHouse(hand)) {
            player.winnings(bet * 6);
            System.out.println("You won: " + bet * 6 + " tokens!");
        } else if (flush(hand)) {
            player.winnings(bet * 5);
            System.out.println("You won: " + bet * 5 + " tokens!");
        } else if (straight(hand)) {
            player.winnings(bet * 4);
            System.out.println("You won: " + bet * 4 + " tokens!");
        } else if (threeKind(hand)) {
            player.winnings(bet * 3);
            System.out.println("You won: " + bet * 3 + " tokens!");
        } else if (twoPairs(hand)) {
            player.winnings(bet * 2);
            System.out.println("You won: " + bet * 2 + " tokens!");
        } else if (onePair(hand)) {
            player.winnings(bet * 1);
            System.out.println("You won: " + bet * 1 + " tokens!");
        }
        return player.getBankroll();
    }

    // Rank counter will create an array of values for each rank found
    private int[] countRanks(ArrayList<Card> hand) {
        // Arraylist counts for 13 ranks
        int[] counts = new int[13];
        // Checks cards in hand
        for (int i = 0; i < hand.size(); i++) {
            // Increase counter of counts at index position of each rank found
            counts[hand.get(i).getRank() - 1]++;
        }
        return counts;
    }

    // Suit counter will create an array of values for each suit found
    private int[] countSuits(ArrayList<Card> hand) {
        // Arraylist counts for 4 suits
        int[] counts = new int[4];
        // Checks cards in hand
        for (int i = 0; i < hand.size(); i++) {
            // Increase counter of counts at index position of each suit found
            counts[hand.get(i).getSuit() - 1]++;
        }
        return counts;
    }

    // Checks if one pair
    private boolean onePair(ArrayList<Card> hand) {
        int[] counter = countRanks(hand);
        // Checks all index positions of rank counter
        for (int r = 0; r < 13; r++) {
            // Checks counter index values to see if there is 2 of a rank
            if (counter[r] == 2) {
                return true;
            }
        }
        return false;
    }

    // Checks if two pairs
    private boolean twoPairs(ArrayList<Card> hand) {
        int[] counter = countRanks(hand);
        // Checks all possible index positions of rank counter
        for (int r1 = 0; r1 < 13; r1++) {
            for (int r2 = r1 + 1; r2 < 13; r2++)
                // Checks counter index values to see if two pairs exist 
                if (counter[r1] == 2 && counter[r2] == 2) {
                    return true;
                }
        }
        return false;
    }

    // Checks if three of a Kind
    private boolean threeKind(ArrayList<Card> hand) {
        int[] counter = countRanks(hand);
        // Checks all index positions of rank counter
        for (int r = 0; r < 13; r++) {
            // Checks counter index values to see if there is 3 of a rank 
            if (counter[r] == 3) {
                return true;
            }
        }
        return false;
    }

    // Checks if straight
    private boolean straight(ArrayList<Card> hand) {
        int[] counter = countRanks(hand);
        // Checks possibilities of straights from 1 to 9
        for (int r = 0; r < 9; r++) {
            boolean flag = true;
            for (int i = 0; i < 5; i++) {
                if (counter[r + i] != 1) {
                    flag = false;
                }
            }
            if (flag == true) {
                return true;
            }
        }
        // Checks if straight from 10 to ace
        boolean flag = true;
        for (int i = 9; i < 13; i++) {
            if (counter[i] != 1 || counter[0] != 1) {
                flag = false;
            }
        }
        if (flag == true) {
            return true;
        }
        return false;
    }

    // Checks if flush
    private boolean flush(ArrayList<Card> hand) {
        int[] counter = countSuits(hand);
        // Checks all index positions of suit counter
        for (int s = 0; s < 4; s++) {
            // Checks counter index values to see if there is 5 of a suit 
            if (counter[s] == 5) {
                return true;
            }
        }
        return false;
    }

    // Checks if full House
    private boolean fullHouse(ArrayList<Card> hand) {
        int[] counter = countRanks(hand);
        // Checks all possible index positions of rank counter
        for (int r1 = 0; r1 < 13; r1++) {
            for (int r2 = r1 + 1; r2 < 13; r2++)
                // Checks to see if there is 3 and 2 of a rank in counter
                if (counter[r1] == 3 && counter[r2] == 2) {
                    return true;
                // Checks to see if there is 2 and 3 of a rank in counter
                } else if (counter[r1] == 2 && counter[r2] == 3) {
                    return true;
                }
        }
        return false;
    }

    // Checks if four of a Kind
    private boolean fourKind(ArrayList<Card> hand) {
        int[] counter = countRanks(hand);
        // Checks all index positions of rank counter
        for (int r = 0; r < 13; r++) {
            // Checks counter index values to see if there is 4 of a rank
            if (counter[r] == 4) {
                return true;
            }
        }
        return false;
    }

    // Checks if straight flush
    private boolean straightFlush(ArrayList<Card> hand) {
        // Checks if flush and straight are true
        if (flush(hand) && straight(hand)) {
            return true;
        }
        return false;
    }

    // Checks if royal flush
    private boolean royalFlush(ArrayList<Card> hand) {
        int[] counter = countRanks(hand);
        boolean flag = true;
        // Checks if straight from 10 to ace
        for (int i = 9; i < 13; i++) {
            if (counter[i] != 1 || counter[0] != 1) {
                flag = false;
            }
        }
        // Checks if straight from 10 to ace and flush
        if (flag == true && flush(hand)) {
            return true;
        }
        return false;
    }

}// End class