package com.accenture.ltt.activities;

/**
 * TODO: Write a program that checks whether a given year is a leap year.
 * Hints:
 *  - A leap year is divisible by 4
 *  - But not divisible by 100 unless divisible by 400
 */
public class ActivityOne {
    public static void main(String[] args) {
        int year = 2026;

        // TODO: Write logic using if-else
        // Output should be "Leap Year" or "Not a Leap Year"

        if ((year % 4 == 0 && year % 100 != 0 ) || year % 400 == 0) {
            System.out.println("Leap Year");
        }
        else{
            System.out.println("Not a Leap Year");
        }
        
    }
}