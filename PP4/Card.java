/**
 * @author: Alex Yu
 * @uni: ajy2116
 * @description: Card class that creates a card and compares cards
 * @date: 3/31/18
 */

public class Card implements Comparable<Card> {

    // Declarations
    private int suit;
    private int rank;
    private String stringSuit;

    // Constructor
    public Card(int s, int r) {
        // Makes a card with suit s and rank r
        suit = s;
        rank = r;
    }

    // Converts card to string for args constructor in Game class
    public Card(String text) {
        // Spade
        if (text.charAt(0) == 's') {
            suit = 1;
        // Club
        } else if (text.charAt(0) == 'c') {
            suit = 2;
        // Diamond
        } else if (text.charAt(0) == 'd') {
            suit = 3;
        // Heart
        } else if (text.charAt(0) == 'h') {
            suit = 4;
        }
        // Rank
        rank = Integer.parseInt(text.substring(1));
    }

    // Compares suits and ranks
    public int compareTo(Card c) {
        int answer = 0;
        if (this.suit < c.suit) {
            answer = -1;
        } else if (this.suit > c.suit) {
            answer = 1;
        } else {
            if (this.rank < c.rank) {
                answer = -1;
            } else if (this.rank > c.rank) {
                answer = 1;
            }
        }
        return answer;
    }

    // Converts the suit to corresponding string for printing purposes
    public String toString() {
        if (suit == 1) {
            // Spade
            stringSuit = "s";
        } else if (suit == 2) {
            // Club
            stringSuit = "c";
        } else if (suit == 3) {
            // Diamond
            stringSuit = "d";
        } else if (suit == 4) {
            // Heart
            stringSuit = "h";
        }
        // Returns the suit and rank of a card
        return stringSuit + Integer.toString(this.rank);
    }

    // Gets the suit
    public int getSuit() {
        return suit;
    }

    // Gets the rank
    public int getRank() {
        return rank;
    }

}// End Class