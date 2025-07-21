package LeetCodePractice.Arrays;

import java.util.List;
import java.util.ArrayList;

public class MultipleAndFactorsOfArrays {
	
	// Given 2 arrays, find number of integers such that they are multiple of first array and factors of second array
	// For this calculate the LCM of first array and GCD of second array
	// Then Check all the multiples of LCM which can divide GCD (factor of GCD)
	public int getTotalMutlipltFactorOfArrays(List<Integer> list1, List<Integer> list2)
	{
		int list1LCM = list1.get(0);
		for(int n : list1)
		{
			list1LCM = getLCM(list1LCM, n);
		}
		
		int list2GCD = list2.get(0);
		for(int n : list2)
		{
			list2GCD = getGCD(list2GCD, n);
		}
		
		// Count multiple of LCM that divides GCD
		int result = 0;
		int multiple = 0;
		while(multiple <= list2GCD)
		{
			multiple += list1LCM;
			
			if(list2GCD % multiple == 0)
			{
				result++;
			}
		}
		
		return result;
	}
	
	// Function to return GCD of 2 numbers
	private int getGCD(int n1, int n2)
	{
		if (n2 == 0)
		{
			return n1;
		}
		else
		{
			return getGCD(n2, n1%n2);
		}
	}
	
	// Function to return LCM of 2 numbers
	private int getLCM(int n1, int n2)
	{
		if (n1 == 0 || n2 == 0)
		{
			return 0;
		}
		else
		{
			int gcd = getGCD(n1, n2);
			return Math.abs(n1 * n2)/gcd;
		}
	}
	
	public static void main(String[] args) {
		List<Integer> nums1 = new ArrayList<>();
		nums1.add(2);
		nums1.add(4);
		
		List<Integer> nums2 = new ArrayList<>();
		nums2.add(16);
		nums2.add(32);
		nums2.add(96);
		
		MultipleAndFactorsOfArrays obj = new MultipleAndFactorsOfArrays();
		int result = obj.getTotalMutlipltFactorOfArrays(nums1, nums2);
		System.out.println("Total common multiple and factors of given 2 list of numbers are "+result);
		
	}

}
