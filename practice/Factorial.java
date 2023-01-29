package practice;

import java.util.Scanner;

public class Factorial
{
	// method to find factorial of given number 
	static int factorial(int n) 
    { 
		if (n == 0) 
			return 1; 
  
		return n * factorial(n - 1); 
    }
	
	// Returns mathematical constant e value
	static float calcConstVal(int n)  
	{  
	    float e = 1; // initialize sum of series  
	  
	    for (int i = 1; i < n; i++)
	    {
	    	e = e + (1/factorial(n));
	    }
	    return e;  
	}
	
	// Returns approximate value of e^x  
	static double calcExpEVal(int n, float x)  
	{  
	    double e = 1; // initialize sum of series
	  
	    for (int i = 1; i < n; i++)
	    {
	    	e = e + ( (Math.pow(x, n)) / (factorial(n)) );
	    }
	    return e;  
	} 
  
    public static void main(String[] args) 
    { 
       Scanner scan = new Scanner(System.in);
       System.out.println("Enter no to calculate factorial: ");
       int no = scan.nextInt();
       System.out.println("Factorial of " + no + " is " + factorial(5));
       
       System.out.println("Enter no of terms to calculate mathematical constant e: ");
       int noOfTerms1 = scan.nextInt();
       System.out.println("Approximate value of mathematical constant e value is " + calcConstVal(noOfTerms1));
       
       System.out.println("Enter no of terms to calculate e^x: ");
       int noOfTerms2 = scan.nextInt();
       System.out.println("Enter value of x to calculate e^x: ");
       float x = scan.nextFloat();
       System.out.println("Approximate value of e^x is " + calcExpEVal(noOfTerms2, x));
       
       scan.close();
    } 
}
