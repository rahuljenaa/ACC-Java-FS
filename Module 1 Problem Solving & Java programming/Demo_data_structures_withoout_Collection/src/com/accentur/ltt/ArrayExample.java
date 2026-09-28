package com.accentur.ltt;

public class ArrayExample {
    public static void main(String[] args) {
        int[] numbers = new int[5]; // Fixed-size array
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;

        System.out.println("Array elements:");
        for (int num : numbers) {
            System.out.println(num);
        }
    }
}

/*
=>Can be replaced with:
List<Integer> numbers = new ArrayList<>();
numbers.add(10);
numbers.add(20);
numbers.add(30);
*/