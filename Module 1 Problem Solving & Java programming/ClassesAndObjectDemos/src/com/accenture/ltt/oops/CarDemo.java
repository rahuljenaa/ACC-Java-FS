package com.accenture.ltt.oops;

/**
 * This class demonstrates how to create and use objects from the Car class.
 */
public class CarDemo {
    public static void main(String[] args) {
        // Creating first car object
        Car car1 = new Car();
        car1.color = "Red";
        car1.brand = "Toyota";
        car1.drive(); // Output: Toyota car is driving in Red color.

        // Creating second car object
        Car car2 = new Car();
        car2.color = "Blue";
        car2.brand = "BMW";
        car2.drive(); // Output: BMW car is driving in Blue color.
    }
}