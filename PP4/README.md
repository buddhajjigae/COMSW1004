# Name: Alex Yu
# UNI: ajy2116
# Assignment: Programming Project 4

===============================================================================
Card.java
===============================================================================

This class makes the cards that will be used in the game by suit and rank. I knew I would have to take an int from 1-13 for the rank and an int from 1-4 for the suit. The compareTo() would rank the cards by suit first starting and rank second. toString() would be for converting the int values of the suit into corresponding string values such as s, c, d, and h. I also knew that I would need methods to getSuit() and getRank(). The string constructor would be for testing purposes as it retrieves string values and converts them into the corresponding suit int values.  
 
===============================================================================
Deck.java
===============================================================================

This class makes the deck using the Card class. Using / and %, I was able to create 52 cards of unique values for suits 1-4 and rank 1-13. shuffle() shuffles the deck by using a temp value to swap positions of the first and second randomly chosen cards. deal() deals the top card based on index position. Top index is set to 0.

===============================================================================
Player.java
===============================================================================

This class creates the player that will play the game. I created clearHand() to remove all cards from the player’s hand after the game has completed if they wanted to play again. addCard() and removeCard() simply add and remove from the player’s hand. Bankroll keeps track of the player’s money and bets() which removes the bet from the bankroll, winnings() which adds to the bankroll based on odds, and getBankroll() are meant to work with bankroll. getHand() simply returns the player’s hand. 

===============================================================================
Game.java
===============================================================================

This class plays the actual game. One can play normally if no args are given or test hands if string args are provided. play() shuffles the deck, clear’s the players hand, deals 5 cards to the player, and then retrieves a bet. Play also allows for the game to be replayed using a boolean while loop. checkHand() runs through all the check methods and reports a string corresponding to the hand evaluation. exchange() exchanges the hand depending on how many cards and which cards the player wants to exchange. winnings() determines how much the player has won based on hand evaluation.

countRanks() and countSuits() both create array lists that will store how many times a suit or a rank has been found. The stored values are increased for each matching value using counter. So if two rank 2’s are found, the array list for countRanks() will show as [0,2,0,…] etc. Suits is similar. Using this I was able to evaluate hands quickly. Straights however, were solved by checking possible straights from 1-9 and then checking for straights 1 + 10-13 separately. 

===============================================================================

How to play: 
1) Run program

2) Enter token value 1-5 that will be bet. Note, you cannot bet more tokens than you have. Once you reach 0 tokens you automatically lose.

3) Enter exchange value 1-5 for how many cards will be exchanged.

4) If exchange value was 1-4, you will be prompted for which cards to exchange. Enter 1-5 for the corresponding position of the card in the hand to be exchanged. Note, you must enter unique values aka you cannot enter card number 2 twice if you choose to exchange 2 cards.  

5) Your hand and winnings will then be evaluated.

6) Enter y to play again using the same bankroll or n to exit the game.
