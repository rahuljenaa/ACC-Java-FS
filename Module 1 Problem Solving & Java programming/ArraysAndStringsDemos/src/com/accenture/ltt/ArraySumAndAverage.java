package com.accenture.ltt;

/**
 * Calculates sum and average of array elements.
 */
public class ArraySumAndAverage {
    public static void main(String[] args) {
        int[] marks = {70, 80, 90, 100, 85};

        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }

        double average = (double) sum / marks.length;

        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
    }
}
