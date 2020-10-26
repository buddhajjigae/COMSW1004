/**
 * @author: Alex Yu
 * @uni: ajy2116
 * @description: Player class that creates a player and bankroll
 * @date: 3/31/18
 */

import java.util.ArrayList;

public class Player {

    // Declarations
    private ArrayList<Card> hand;
    private double bankroll;

    // Constructor
    public Player() {
        // Creates hand array list of card
        hand = new ArrayList<Card>();
        // Sets bankroll
        bankroll = 50.0;
    }

    // Clear's a player's hand by removing all elements from array list
    public void clearHand() {
        hand.removeAll(hand);
    }

    // Add card c to the player's hand
    public void addCard(Card c) {
        hand.add(c);
    }

    // Remove card c from the player's hand
    public void removeCard(Card c) {
        // Checks to see if hand size is atleast 1
        if (hand.size() > 0) {
            hand.remove(c);
        }
    }

    // Player makes a bet and adjusts bankroll
    public void bets(double amt) {
        bankroll = bankroll - amt;
    }

    // Adjusts the bankroll if player wins
    public void winnings(double odds) {
        bankroll = bankroll + odds;
    }

    // Gets the current balance of bankroll
    public double getBankroll() {
        return bankroll;
    }

    // Gets the hand
    public ArrayList<Card> getHand() {
        return hand;
    }

}// End class