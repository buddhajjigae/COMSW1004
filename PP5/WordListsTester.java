/**
 * @author: Alex Yu
 * @uni: ajy2116
 * @description: WordLists Tester class that will run all methods in WordLists
 * @date: 4/16/18
 */

import java.io.FileNotFoundException;

public class WordListsTester {

    public static void main(String[] args) throws FileNotFoundException {

        // Text file with all the words
        String fileName = "dictionary.txt";
        WordLists words;

        // Catches file not found exception
        try {
            words = new WordLists(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found");
            return;
        }

        // Runs all methods using hardcoded inputs
        try {
            // Length N words
            System.out.println("Matching words written to lengthN.txt");
            System.out.println(words.lengthN(14).size() + " words were found.");

            // Starts with words
            System.out.println("Matching words written to startsWith.txt");
            System.out.println(words.startsWith('b', 4).size() + " words were" +
                    " found.");

            // Contains letter words
            System.out.println("Matching words written to containsLetter.txt");
            System.out.println(words.containsLetter('h', 4).size() + " words " +
                    "were found.");

            // Multi letter words
            System.out.println("Matching words written to multiLetter.txt");
            System.out.println(words.multiLetter('o', 5).size() + " words " +
                    "were found.");

        // Catches output file exception
        } catch (FileNotFoundException e) {
            System.out.println("Output file could not be created");
        // Catches illegal argument exception for int input
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal Argument");
        }
    }

}// End class