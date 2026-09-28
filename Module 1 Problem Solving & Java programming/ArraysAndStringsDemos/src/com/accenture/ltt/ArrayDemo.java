package com.accenture.ltt;

/**
 * Demonstrates different types of arrays in Java.
 */
public class ArrayDemo {
    public static void main(String[] args) {
        // 1. Declare and initialize an integer array
        int[] numbers = {10, 20, 30, 40, 50};

        // Accessing and printing elements
        System.out.println("Array Elements:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Index " + i + ": " + numbers[i]);
        }

        // 2. Calculate sum of array elements
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("Sum = " + sum);

        // 3. String array
        String[] fruits = {"Apple", "Banana", "Cherry"};
        System.out.println("Fruits:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}