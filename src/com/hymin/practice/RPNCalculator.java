package com.hymin.practice;

import java.text.NumberFormat;
import java.util.ArrayDeque;  
import java.util.Deque;  
import java.util.Scanner;
  
/** 
 * Reverse Polish Notation calcultion 
 *  
 * @author Robert Luo 
 *  
 *         Evaluate the value of an arithmetic expression in Reverse Polish 
 *         Notation. 
 *  
 *         Valid operators are +, -, *, /, undo, clear. Each operand may be an integer or 
 *         another expression. 
 *  
 *         Some examples: "4 2 3 * +" => (4 + 2 * 3) -> 10 
 *         "27 3 4 5 + * /" => ((4 + 5) * 3) / 27-> 1
 *  
 */  
public class RPNCalculator {
	//numbers should be stored with at least 15 decimal places of precision, but displayed in
	//plain decimal format (no engineering format) with 10 decimal places of precision
	private static NumberFormat nFormat = NumberFormat.getNumberInstance();
	static {
		nFormat.setMaximumIntegerDigits(5);
    	nFormat.setMaximumFractionDigits(10);
	}
  
    /**
     * Parse the inputs in String array and do RPN calculation
     * @param tokens
     * @return the result of calculation
     */
	public static String evalRPN(String[] tokens) {
  
        // Local stack variable used to traverse original String array
        Deque<Double> stack = new ArrayDeque<Double>();  
  
        double a, b;  //to store two operands on stack
        Double prevB = null; //to store previous operand
  
        /** 
         * loop through the String array
         * if the current token is an operator, fetch two elements out from stack and do calculation，then store the result into stack 
         * if the current token is number, push it onto stack
         */  
        for (int i = 0; i < tokens.length; i++) {  
            String temp = tokens[i];  
            switch (temp) {  
            case "+":  
                try {
            	    a = stack.pop();  
                    b = stack.pop();
                } catch (java.util.NoSuchElementException nee) { //there are no sufficient parameters on stack
                	return getInsufficientParamMsg("+", i);
                }
                stack.push(b + a);
                prevB = b;
                break;  
            case "-":  
            	try {
            	    a = stack.pop();  
                    b = stack.pop();
                } catch (java.util.NoSuchElementException nee) {
                	return getInsufficientParamMsg("-", i);
                } 
                stack.push(b - a);  
                prevB = b;
                break;  
            case "*":  
            	try {
            	    a = stack.pop();  
                    b = stack.pop();
                } catch (java.util.NoSuchElementException nee) {
                	return getInsufficientParamMsg("*", i);
                }
                stack.push(b * a);  
                prevB = b;
                break;  
            case "/":  
            	try {
            	    a = stack.pop();  
                    b = stack.pop();
                } catch (java.util.NoSuchElementException nee) {
                	return getInsufficientParamMsg("/", i);
                } 
                if (a == 0) {  
                    return nFormat.format(-1);  
                }  
                stack.push(b / a); 
                prevB = b;
                break;
            case "undo":
            	if (!stack.isEmpty()) {
            		stack.removeFirst();
            	}
                if (prevB != null) {
                    stack.push(prevB);
                }
                break;
            case "clear":   
                stack.clear();  
                break;
            default:  
            	try {
                    stack.push(Double.parseDouble(temp));  
            	} catch (java.lang.NumberFormatException nfe) {
            		return "Invalid input at: " + i;
            	}
            }  
        }  
  
        double result = !stack.isEmpty()? stack.peek() : 0;  
  
        return nFormat.format(result);  
    }
    
	/**
	 * prints a warning message in format "operator &lt;operator&gt; (position: &lt;position&gt;): insufficient parameters"
	 * @param operator the current operator
	 * @param index the index of the operator
	 * @return warning message
	 */
    public static String getInsufficientParamMsg(String operator, int index) {
    	StringBuffer sb = new StringBuffer();
    	sb.append("operator ");
    	sb.append(operator);
    	sb.append(" (position: ");
    	sb.append(index);
    	sb.append("): insufficient parameters");
    	return sb.toString();
    }
  
    /**
     * main function
     * @param args
     */
    public static void main(String[] args) {  
//        String[] input = new String[] { "6", "3", "1", "+", "5", "*", "undo", "+"};  
//        System.out.println(evalRPN(input));  
        Scanner sc = new Scanner(System.in);
        System.out.println("Waiting input...");  
        while (true) {
        	try {
                String temp = sc.nextLine();  
                if (temp.trim().equals("exit") || temp.trim().equals("bye")) {  
                    return;  
                }
                String[] input = temp.split(" ");
                System.out.println(evalRPN(input));  
        	} catch (Exception ex) {
        		return;
        	}
        }
    }  
  
}
