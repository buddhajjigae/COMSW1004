//*************************************
//
//  WordLists.java
//
//  Class to aid with Scrabble
//  Programming Project 5, COMS W1004
//
//
//  Your Name: Alex Yu
//  Your Uni: ajy2116
//**************************************

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class WordLists {

    // Declarations
    private String word;
    private ArrayList<String> wordList;
    private Scanner input;
    private File inFile;

    // Constructor
    public WordLists(String fileName) throws FileNotFoundException {
        inFile = new File(fileName);
        wordList = new ArrayList<String>();
        Scanner input = new Scanner(inFile);
        // Adds words from file to wordList array list
        while (input.hasNext()) {
            word = input.nextLine();
            wordList.add(word);
        }
    }

    // LengthN method, finds length N words
    public ArrayList<String> lengthN(int n) throws FileNotFoundException {
        // Throws illegal argument exception must be atleast length 1
        if (n < 1) {
            throw new IllegalArgumentException("Int must be greater than 0");
        }

        ArrayList<String> matches = new ArrayList<String>();
        // Output file
        PrintWriter output = new PrintWriter("lengthN.txt");
        for (String word : wordList) {
            // Checks if length is n
            if (word.length() == n) {
                matches.add(word);
                // Prints words to lengthN.txt 
                output.println(word);
            }
        }
        output.close();
        return matches;
    }

    // StartsWith method, finds words starting with and length N
    public ArrayList<String> startsWith(char firstLetter, int n) throws
            FileNotFoundException {
        // Throws illegal argument exception must be atleast length 1
        if (n < 1) {
            throw new IllegalArgumentException("Int must be greater than 0");
        }

        ArrayList<String> matches = new ArrayList<String>();
        // Output file
        PrintWriter output = new PrintWriter("startsWith.txt");
        for (String word : wordList) {
            // Checks if first char is first letter and length is n
            if (word.charAt(0) == firstLetter && word.length() == n) {
                matches.add(word);
                // Prints words to startsWith.txt
                output.println(word);
            }
        }
        output.close();
        return matches;
    }

    // ContainsLetter method, finds words containing but not begin and length N
    public ArrayList<String> containsLetter(char included, int n) throws
            FileNotFoundException {
        // Throws illegal argument exception must be atleast length 1
        if (n < 1) {
            throw new IllegalArgumentException("Int must be greater than 0");
        }

        ArrayList<String> matches = new ArrayList<String>();
        // Output file
        PrintWriter output = new PrintWriter("containsLetter.txt");
        for (String word : wordList) {
            // Flag is true if the character is included
            boolean flag = false;
            // Checks to see that the char is not first letter and length n
            if (word.charAt(0) != included && word.length() == n) {
                // Checks each word starting at index 1
                for (int j = 1; j < word.length(); j++) {
                    // Checks to see if char is included
                    if (word.charAt(j) == included) {
                        flag = true;
                    }
                }
            }
            // Adds words to matches if flag is true
            if (flag == true) {
                matches.add(word);
                // Prints words to containsLetter.txt
                output.println(word);
            }
        }
        output.close();
        return matches;
    }

    // MultilLetter method, finds words containing letter m times
    public ArrayList<String> multiLetter(char included, int m)
            throws FileNotFoundException {
        // Throws illegal argument exception must contain letter atleast 1 time
        if (m < 1) {
            throw new IllegalArgumentException("Int must be greater than 0");
        }

        ArrayList<String> matches = new ArrayList<String>();
        // Output file
        PrintWriter output = new PrintWriter("multiLetter.txt");
        for (String word : wordList) {
            // Counter for m
            int count = 0;
            // Checks each word to see if char is included
            for (int j = 0; j < word.length(); j++) {
                // Increases counter for each char included match
                if (word.charAt(j) == included) {                   
                    count++;
                }
            }
            // Adds words to matches if counter is m
            if (count == m) {
                matches.add(word);
                // Prints words to multiLetter.txt
                output.println(word);
            }
        }
        output.close();
        return matches;
    }

} // End class