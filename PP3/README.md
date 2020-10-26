# Name: Alex Yu
# UNI: ajy2116
# Assignment: Programming Project 3

===============================================================================
CreditCard.java
===============================================================================

For the Credit class, I realized that I would need a method for each check required along with an int for error code and a string for the card number. Therefore, I made the main method check() run all the individual check methods and have it return the card using isValid() if the card number passed all checks. Each check method required a different condition to validate but most of them required a new function called parseInt(). This would take a string and covert it or a char in the string into an int. 

Additionally, each check method would be based upon checking if the number did not pass the check requirements so != was extensively used. The isValid() method would simply return whether the card number was valid or not and getErrorCode() would simply return the first error code received during the six checks so that we would know where the number failed first.

CreditCardTester class used was provided by the Professor and not altered. 
 
===============================================================================
Game.java
===============================================================================

For the Game class, I knew that I would have to generate three random numbers for mode (between 0 and 1), first turn (between 0 and 1), and marbles (between 10 and 100) in the constructor. The play() method would then let the first turn player go and then the next player and so on while displaying how many marbles were left after each turn by calling getChoice() from the Human or Computer class and then subtracting their choice from the remaining marbles. Once the marble count reaches 1, play() will call victory() which will announce who wins.

Nim class used was provided by the Professor and not altered. 

===============================================================================
Human.java
===============================================================================

For the Human class, I just needed to scan an int input that would determine the human players move. This scanned int would then be verified by the move() method to see if it was a legal move or not (a number that is at least 1 and at most, half the marbles). If the move was not legal, the user will be prompted to input another int. If the move was legal, the Game class would call getChoice() from the Human class which would return the users move. The marbles remaining will then be determined by subtracting the move from the current marbles remaining.

===============================================================================
Computer.java
===============================================================================

For the Computer class, I needed to generate a random number for either the smart mode or stupid mode move. The constructor would take the mode generated from Game class and then send that to the move() method. move() would then generate a move depending on the mode. For stupid mode, the computer will take a randomly generated number between 1 and n/2. For smart mode, I used a while loop to go through each power of 2 less than or equal to 64. If the marbles left were equal to a power of 2 minus 1, then the computer would generate a random legal move used in stupid move. Else, the while loop will check to see what the next lowest power of 2 value was in comparison to the marbles left (the declared int 64 will be divided by 2 to keep checking for the next lowest power of 2 value). After the comparison, the loop will then remove enough marbles to make the marbles left equal to the next lowest power of 2 minus 1. If the move was legal, the Game class would call getChoice() from the Human class which would return the users move. The marbles remaining will then be determined by subtracting the move from the current marbles remaining.
