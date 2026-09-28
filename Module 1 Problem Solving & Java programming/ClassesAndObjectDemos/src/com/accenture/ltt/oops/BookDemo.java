package com.accenture.ltt.oops;

/**
 * Demonstrates constructor usage with Book class.
 */
public class BookDemo {
    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "John Smith");
        Book b2 = new Book("OOP Concepts", "Jane Doe");

        b1.display();
        b2.display();
    }
}