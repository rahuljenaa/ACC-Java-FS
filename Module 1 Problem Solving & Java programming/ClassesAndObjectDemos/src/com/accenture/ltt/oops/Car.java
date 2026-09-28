package com.accenture.ltt.oops;

/**
 * This class represents a Car with a color and a behavior to drive.
 */
public class Car {
    // Fields / attributes
    String color;
    String brand;

    // Method / behavior
    public void drive() {
        System.out.println(brand + " car is driving in " + color + " color.");
    }
}