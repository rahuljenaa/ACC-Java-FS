package com.accenture.ltt.oops;

/**
 * Represents a book using constructor initialization.
 */
public class Book {
    String title;
    String author;

    // Constructor
    public Book(String t, String a) {
        title = t;
        author = a;
    }

    public void display() {
        System.out.println("Book: " + title + " by " + author);
    }
}