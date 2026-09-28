package com.accenture.ltt.ui.tester.java17;

import java.util.random.RandomGenerator;

public class RandomDemo {
    public static void main(String[] args) {
        // Create a PRNG using a specific algorithm
        RandomGenerator rng = RandomGenerator.of("L64X128MixRandom");

        // Generate random integers
        System.out.println("Random int: " + rng.nextInt(100));
        System.out.println("Random double: " + rng.nextDouble());

        // Generate 5 random numbers as a stream
        rng.ints(5, 1, 10).forEach(System.out::println);
    }
}
