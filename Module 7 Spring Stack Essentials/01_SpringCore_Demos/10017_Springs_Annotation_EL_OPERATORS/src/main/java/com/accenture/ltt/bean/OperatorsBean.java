package com.accenture.ltt.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("operatorBean")
public class OperatorsBean {

	//Relational operators
	
	@Value("#{1 == 1}") //true
	private boolean testEqual;
	
	@Value("#{1 != 1}") //false
	private boolean testNotEqual;
	
	@Value("#{1 < 1}") //false
	private boolean testLessThan;
	
	@Value("#{1 <= 1}") //true
	private boolean testLessThanOrEqual;
	
	@Value("#{1 > 1}") //false
	private boolean testGreaterThan;
	
	@Value("#{1 >= 1}") //true
	private boolean testGreaterThanOrEqual;

	//Logical operators \n, numberBean.no == 999
	
	@Value("#{numberBean.no == 999 and numberBean.no < 900}") //false
	private boolean testAnd;
	
	@Value("#{numberBean.no == 999 or numberBean.no < 900}") //true
	private boolean testOr;
	
	@Value("#{!(numberBean.no == 999)}") //false
	private boolean testNot;

	@Value("#{2 > 1 ? 'a' : 'b'}") // "a"
	private String ternary;
	
	@Value("#{null ?: 'b'}") // "b"
	private String elvis;
	
	
	//Mathematical operators
	
	@Value("#{1 + 1}") //2.0
	private double testAdd;
	
	@Value("#{'1' + '@' + '1'}") //1@1
	private String testAddString;
	
	@Value("#{1 - 1}") //0.0
	private double testSubtraction;

	@Value("#{1 * 1}") //1.0
	private double testMultiplication;
	
	@Value("#{10 / 2}") //5.0
	private double testDivision;
	
	@Value("#{10 % 10}") //0.0
	private double testModulus ;
	
	@Value("#{2 ^ 2}") //4.0
	private double testExponentialPower;

	public void testElvisTernary() {
		System.out.println(elvis + " " + ternary);
	}
	@Override
	public String toString() {
		return "OperatorBean [testEqual=" + testEqual + "\n, testNotEqual="
				+ testNotEqual + "\n, testLessThan=" + testLessThan
				+ "\n, testLessThanOrEqual=" + testLessThanOrEqual
				+ "\n, testGreaterThan=" + testGreaterThan
				+ "\n, testGreaterThanOrEqual=" + testGreaterThanOrEqual
				+ "\n, testAnd=" + testAnd + "\n, testOr=" + testOr + "\n, testNot="
				+ testNot + "\n, testAdd=" + testAdd + "\n, testAddString="
				+ testAddString + "\n, testSubtraction=" + testSubtraction
				+ "\n, testMultiplication=" + testMultiplication
				+ "\n, testDivision=" + testDivision + "\n, testModulus="
				+ testModulus + "\n, testExponentialPower="
				+ testExponentialPower + "]";
	}
	
}