# README.txt
# Name: Alex Yu
# UNI: ajy2116
# Assignment: Programming Project 5

===============================================================================
WordLists.java
===============================================================================

This class contains the four methods to find matching words from a text file. I knew that I would be taking in files and making output files along with catching and throwing exceptions so I had to import java.io.File, java.io.FileNotFound, and java.io.PrintWriter. The constructor takes a file and writes the words in the file into array list wordList. Each of the methods throws an illegal argument exception to prevent int values less than 1 because the length should be at least 1 to find a word and there should be at least 1 m occurrence for the last method to find a word. The first method, lengthN() finds all words of length n. The second method, startsWith() finds all words of length n beginning with a certain letter. The third method, containsLetter() finds all words of length n that include a certain character while not beginning with the character. The fourth method, multiLetter() finds all words that include a character m amount of times. Each method independently prints the results to a designated txt file. The class also throws file not found exceptions.
 
===============================================================================
WordListsTester.java
===============================================================================

This class tests the WordLists class. It takes hardcoded inputs for the file name and for the method arguments. It begins with a catch for file not found exception. Then it runs each method using the hardcoded inputs while printing that each method has outputted a corresponding txt file with the matching words. It also prints how many words were found. The end of the class catches file not found exception for the output files and illegal argument exception to prevent non int values from being used. java.io.FileNotFoundException was also imported for file not found exceptions.

===============================================================================
