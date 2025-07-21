package LeetCodePractice.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindDuplicates {

	// Given a array with values ranging from 0 to length of array, find numbers which has duplicates
	// This can be solved using hashset which takes unique value and if already a value is there, it can be added to result. But this uses O(N) space
	// For O(1) space, loop through each element, take the value as index. Then negate the value at that index. Means - a[1]=3 and a[3]=6, then after negating related index data, a[3]=-6
	// Check if same value re-occurs then, then check if its index already have negative value, means its a duplicate
	public List<Integer> findDuplicatesConstantSpace(int[] arr)
	{
		List<Integer> result = new ArrayList<>();
		for(int i=0; i<arr.length; i++)
		{
			int index_val = Math.abs(arr[i]) - 1;
			
			if (arr[index_val] < 0)
			{
				result.add(Math.abs(arr[i]));
			}
			arr[index_val] = arr[index_val] * -1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of input array:");
		int size = sc.nextInt();
		int[] inputArr = new int[size];
		System.out.println("Enter array values:");
		for(int i=0; i<size; i++)
		{
			inputArr[i] = sc.nextInt();
		}
		sc.close();
		
		FindDuplicates fd = new FindDuplicates();
		List<Integer> result = fd.findDuplicatesConstantSpace(inputArr);
		System.out.println("Elements which are duplicates in given array are: "+result.toString());
	}
}
