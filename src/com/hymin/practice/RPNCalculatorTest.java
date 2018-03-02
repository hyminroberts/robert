package com.hymin.practice;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/** 
 * To test evalRPN and getInsufficientParamMsg functions in Calculator class
 *  
 * @author Robert Luo 
 *  
 */ 
public class RPNCalculatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testEvalRPN() {
		String[] inputA = {"6", "3", "1", "+", "5", "*", "undo", "+"};
		Assert.assertEquals("10", RPNCalculator.evalRPN(inputA));
		String[] inputB = {"4", "2", "3", "5", "4", "+", "-", "*", "/"};
		Assert.assertEquals("-0.3333333333", RPNCalculator.evalRPN(inputB));
		String[] inputC = {"3", "-"};
		Assert.assertEquals("operator - (position: 1): insufficient parameters", RPNCalculator.evalRPN(inputC));
		String[] inputD = {"3", "4", "+", "clear", "1"};
		Assert.assertEquals("1", RPNCalculator.evalRPN(inputD));
		String[] inputE = {"2", "3", "undo"};
		Assert.assertEquals("2", RPNCalculator.evalRPN(inputE));
	}

	@Test
	public void testGetInsufficientParamMsg() {
		Assert.assertEquals("operator - (position: 1): insufficient parameters", RPNCalculator.getInsufficientParamMsg("-", 1));
	}
	
	public static void main(String[] args) {
	      Result result = JUnitCore.runClasses(RPNCalculatorTest.class);
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      System.out.println(result.wasSuccessful());
	   }

}
