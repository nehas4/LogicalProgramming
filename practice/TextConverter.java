package practice;

import java.util.Scanner;

public class TextConverter {
	public static void main(String[] args) {
		String current, action;
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Text Converter.");
		System.out.println("Available Actions:");
		System.out.println(" 1337) convert to 1337-speak");
		System.out.println(" rev) reverse the string");
		System.out.println(" quit) exit the program\n");
		System.out.println("Please enter a string: ");
		current = sc.nextLine();
		
		do {
			System.out.println("Action (1337, rev, quit): ");
			action = sc.nextLine();
			if("1337".equals(action))
			{
				current = action1337(current);
			} else if("rev".equals(action)) {
				current = actionReverse(current);
			} else if("quit".equals(action)) {
				flag = false;
				System.out.println("See you next time!");
			} else {
				System.out.println("Unrecognized action.");
			}
			
			System.out.println(current);
		} while (flag);
		
		//closing the scanner
		sc.close();
		
		testAction1337(); //uncomment to run the tests
		testActionReverse(); //uncomment to run the tests
	}
	
	public static String action1337(String current) {
		String replaced_string;
		replaced_string = current.replace("L", "1");
		replaced_string = replaced_string.replace("l", "1");
		replaced_string = replaced_string.replace("E", "3");
		replaced_string = replaced_string.replace("e", "3");
		replaced_string = replaced_string.replace("T", "7");
		replaced_string = replaced_string.replace("t", "7");
		replaced_string = replaced_string.replace("O", "0");
		replaced_string = replaced_string.replace("o", "0");
		replaced_string = replaced_string.replace("S", "$");
		replaced_string = replaced_string.replace("s", "$");
		return replaced_string;
	}
	
	// test method to test action1337() execution
	public static void testAction1337() {
		boolean error = false;
		
		String input1 = "LEeTs";
		String expected1 = "1337$";
		String result1 = action1337 (input1);
		if ( !result1.equals( expected1)) {
			error = true;
			System.out.println("1) testAction1337 with input " + input1 + ", expected: " + expected1 + " but result:" + result1);
		}
		
		if ( error) {
			System.out.println("testAction1337 failed");
		} else {
			System.out.println("testAction1337 passed");
		}
	}
	
	public static String actionReverse(String current) {
		StringBuilder reverse_string = new StringBuilder(current);
		return reverse_string.reverse().toString();
	}
	
	// test method to test actionReverse() execution
	public static void testActionReverse() {
		boolean error = false;
		
		String input1 = "Abc";
		String expected1 = "cbA";
		String result1 = actionReverse( input1);
		if ( !result1.equals( expected1)) {
			error = true;
			System.out.println("1) testActionReverse with input " + input1 + ", expected: " + expected1 + " but result:" + result1);
		}
		
		if ( error) {
			System.out.println("testActionReverse failed");
		} else {
			System.out.println("testActionReverse passed");
		}
	}
}
