package com.accenture.ltt;

/**
 * Counts the number of words in a sentence.
 */
public class StringWordCount {
    public static void main(String[] args) {
        String sentence = "Java is a powerful programming language";

        String[] words = sentence.split(" "); // split by space

        System.out.println("Word count: " + words.length);
    }
}