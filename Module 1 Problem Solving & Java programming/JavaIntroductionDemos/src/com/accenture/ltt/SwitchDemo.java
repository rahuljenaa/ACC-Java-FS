package com.accenture.ltt;

/**
 * Demonstrates switch-case control structure in Java.
 */
public class SwitchDemo {
    public static void main(String[] args) {
        int day = 3;

        // Match value of 'day' with one of the cases
        switch (day) {
            case 1:
                System.out.println("Monday");
                break; // Prevents fall-through
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Invalid Day");
        }
    }
}
