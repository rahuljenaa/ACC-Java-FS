package com.accenture.ltt.comments;

public class CommentTagDemo {

    public static void main(String[] args) {
        String userInput = null;

        // TODO: Get user input from console or UI
        // Currently hardcoded for demonstration
        userInput = " John Doe ";

        System.out.println(userInput.length());
        // FIXME: This will throw an exception if userInput is null
        // Should add a null check before calling trim()
        String trimmedName = userInput.trim();

        // NOTE: Using toUpperCase to normalize name for display
        System.out.println("Welcome, " + trimmedName.toUpperCase()+ " " +trimmedName.length());
    }
}
