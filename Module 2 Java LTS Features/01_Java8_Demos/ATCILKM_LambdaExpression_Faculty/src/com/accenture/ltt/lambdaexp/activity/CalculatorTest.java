package com.accenture.ltt.lambdaexp.activity;

/**
 * CalculatorTest class which perform addition, subtraction, multiplication 
 * and division depending upon the implementation of Calculator.
 *
 */
public class CalculatorTest {
	
	/**
	 * Calling Calculator.operation method by passing value of a, b
	 * @param a
	 * @param b
	 * @param op
	 * @return
	 */
	public int operate(int a, int b, Calculator op) {		
		return op.operation(a, b);
    }
	
	public static void main(String[] args) {
		
		//TODO 1 - Create CalculatorTest object
		CalculatorTest calculatorTest = new CalculatorTest();
		//TODO 2 - Create Calculator implementation addition using lambda expression and add both the parameters value 
		Calculator addition = (a,b) -> a+b;
		//TODO 3 - Create Calculator implementation subtraction using lambda expression and subtract both the parameters value
		Calculator subtraction = (a,b) -> a-b;
		//TODO 4 - Create Calculator implementation multiplication using lambda expression and multiply both the parameters value
		Calculator multiplication = (a,b) -> a*b;
		//TODO 5 - Create Calculator implementation division using lambda expression and divide both the parameters value
		Calculator division = (a,b) -> a/b;
		//TODO 6 - Assign the value to int variable by calling operate method using object of CalculatorTest class and pass 'a' as 30, 'b' as 20 and addition reference
		int addValue = calculatorTest.operate(30, 20, addition);
		//TODO 7 - Assign the value to int variable by calling operate method using object of CalculatorTest class and pass 'a' as 30, 'b' as 20 and subtraction reference
		int subValue = calculatorTest.operate(30, 20, subtraction);
		//TODO 8 - Assign the value to int variable by calling operate method using object of CalculatorTest class and pass 'a' as 30, 'b' as 20 and multiplication reference
		int mulValue = calculatorTest.operate(30, 20, multiplication);
		//TODO 9 - Assign the value to int variable by calling operate method using object of CalculatorTest class and pass 'a' as 30, 'b' as 20 and division reference
		int divValue = calculatorTest.operate(30, 20, division);
		//TODO 10 - Print the values found in step 6 to 9
		System.out.println("addValue = " + addValue + " subValue = " + subValue + " mulValue = " + mulValue + " divValue = " + divValue);
	}

}
