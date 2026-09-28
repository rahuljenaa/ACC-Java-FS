package com.accenture.ltt;

/**
 * Converts a string into character array and prints characters.
 */
public class StringToCharArray {
    public static void main(String[] args) {
        String text = "HELLO";

        char[] chars = text.toCharArray();

        System.out.println("Characters in the string:");
        for (char c : chars) {
            System.out.println(c);
        }
    }
}