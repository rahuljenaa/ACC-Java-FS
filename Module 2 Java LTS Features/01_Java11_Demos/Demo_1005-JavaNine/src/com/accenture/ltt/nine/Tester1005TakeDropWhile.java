package com.accenture.ltt.nine;

import java.util.stream.IntStream;

public class Tester1005TakeDropWhile {

    public static void main(String... args ) {

        System.out.println("Before takeWhile");
        IntStream.range(1, 100)
                .filter(i -> i < 4) // applied to all elements
                .forEach(System.out::print);

        System.out.println("\nWith takeWhile, only the first 4 elements are "
        		+ " evaluated against the predicate.");
        IntStream.range(1, 100)
                .takeWhile(i -> i < 4) // short-circuits on element '4'
                .forEach(System.out::print);


        System.out.println("\nBefore dropWhile");
        IntStream.range(1, 10)
                .filter(i -> i >= 4)
                .forEach(System.out::print);

        System.out.println("\nWith dropWhile (only works if Stream is sorted!");
        IntStream.range(1, 10)
                .dropWhile(i -> i < 4)
                .forEach(System.out::print);
    }

}
//Use with ordered Streams