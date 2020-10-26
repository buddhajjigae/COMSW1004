/**
 * @author: Alex Yu
 * @uni: ajy2116
 * @description: Deck class that creates the deck, shuffles, and deals
 * @date: 3/31/18
 */

import java.util.Arrays;
import java.util.Random;

public class Deck {

    // Declarations
    private Card[] cards;
    // Index position of top card
    private int top = 0;

    // Constructor
    public Deck() {
        // Creates a Card array list of 52 size
        cards = new Card[52];
        for (int i = 0; i < 52; i++) {
            // Creates each card of suit 1-4 and rank 1-13
            cards[i] = new Card(i / 13 + 1, i % 13 + 1);
        }
    }

    // Shuffles the deck
    public void shuffle() {
        Random rand = new Random();
        // Temp card for value holding
        Card temp;
        for (int i = 0; i < 1000; i++) {
            // Obtains random first card to be swapped
            int first = rand.nextInt(52);
            // Obtains random second card to be swapped
            int second = rand.nextInt(52);
            // Temp value is set to the first card value
            temp = cards[first];
            // First card vale is set to the second card value
            cards[first] = cards[second];
            // Second card is set to the first card value
            cards[second] = temp;
        }
        top = 0;
    }

    // Deals the top card in the deck
    public Card deal() {
        // Prevents dealing past the 52nd card
        if (top < 52) {
            // Changes the top card index
            top = top + 1;
        } else {
            // Resets top to 1 if top is greater than 52
            top = 1;
        }
        return cards[top - 1];
    }

}// End Class