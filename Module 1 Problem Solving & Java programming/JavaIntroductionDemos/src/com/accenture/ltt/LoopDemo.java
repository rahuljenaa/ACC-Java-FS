package com.accenture.ltt;

/**
* Demonstrates different loop structures in Java.
*/
public class LoopDemo {
   public static void main(String[] args) {

       // For loop: Executes known number of times
       System.out.println("For loop:");
       for (int i = 1; i <= 5; i++) {
           System.out.println("Count: " + i);
       }

       // While loop: Executes as long as condition is true
       System.out.println("\nWhile loop:");
       int j = 1;
       while (j <= 5) {
           System.out.println("Count: " + j);
           j++;
       }

       // Do-while loop: Executes at least once
       System.out.println("\nDo-While loop:");
       int k = 1;
       do {
           System.out.println("Count: " + k);
           k++;
       } while (k <= 5);
   }
}
