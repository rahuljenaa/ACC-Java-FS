package com.accenture.ltt.JavaDoc;

/**
 * The Calculator class provides basic arithmetic operations.
 * <p>
 * This class supports addition, subtraction, multiplication, and division
 * for integers and doubles.
 * </p>
 *
 * @author r.roopavathi.n
 *
 * @since 2025-08-13
 */
public class Calculator {

    /**
     * Adds two integers.
     *
     * @param a the first integer
     * @param b the second integer
     * @return the sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Divides one number by another.
     *
     * @param numerator the number to be divided
     * @param denominator the number to divide by
     * @return the result of division
     * @throws ArithmeticException if denominator is zero
     */
    public double divide(double numerator, double denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return numerator / denominator;
    }
    
  
    /**
     * The entry point of the Calculator application.
     * <p>
     * This method demonstrates the usage of the {@link #add(int, int)} method
     * by performing a simple addition operation and printing the result.
     * </p>
     *
     * @param args command-line arguments (not used in this program)
     */
    
     
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // Perform addition of two numbers
        int sum = calculator.add(5, 10);

        // Print the result
        System.out.println("Sum: " + sum);
    }

}
