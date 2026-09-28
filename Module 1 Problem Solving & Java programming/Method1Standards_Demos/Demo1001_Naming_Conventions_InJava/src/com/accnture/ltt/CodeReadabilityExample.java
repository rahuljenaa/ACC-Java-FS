package com.accnture.ltt;


public class CodeReadabilityExample {

    // Constants for price and quantity
    public static final double PRICE_PER_ITEM = 20.5;
    public static final int QUANTITY = 5;

    public static void main(String[] args) {
        // Calculate the total cost
        int total = calculateTotal(PRICE_PER_ITEM, QUANTITY);

        // If the user is active, send a notification
        User user = new User(true); // Assuming a User class with a constructor
      
        if (user.isActive()) {
            sendNotification();
        }

        // Output the total
        System.out.println("Total Price: " + total);
    }

    // Method to calculate the total cost
    public static int calculateTotal(double price, int quantity) {
        return (int) (price * quantity);
    }

    // Method to send a notification
    public static void sendNotification() {
        System.out.println("Notification sent!");
    }
}

class User {
    private boolean active;

    // Constructor to initialize the user's status
    public User(boolean active) {
        this.active = active;
    }

    // Method to check if the user is active
    public boolean isActive() {
        return active;
    }
}

