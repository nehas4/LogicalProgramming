package LeetCodePractice.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TwoSums {
	
	
	// Brute force method to get two values in array that has sum equal to target value
	// Its Time complexity is O(N^2)
	public int[] twoSumBruteForce(int[] arr, int targetVal)
	{
		for(int i=0; i<arr.length; i++)
		{
			for(int j=i+1; j<arr.length; j++)
			{
				if(arr[i] + arr[j] == targetVal)
				{
					return new int[]{i, j};
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution!!");
	}

	// Function to find 2 values in an array that is equal to given target value
	// For this here we sort the array and maintain 2 pointers: one at start and one at end
	// Sum the left and right pointer to check if equal to target value
	// If not then move the left or right pointer accordingly until we find 2 values with required sum
	// Time Complexity = NLog(N)
	public int[] towSumSorting(int[] arr, int targetVal)
	{
		// Sort the array to traverse the array from start and end using 2 pointers
		int[] copy_arr = Arrays.copyOf(arr, arr.length);
		Arrays.sort(copy_arr);
		
		int left = 0;
		int right = arr.length - 1;
		int num1 = 0, num2 = 0;
		
		while(left < right)
		{
			int sum = copy_arr[left] + copy_arr[right];
			if(sum > targetVal)
			{
				right--;
			}
			else if(sum < targetVal)
			{
				left++;
			}
			if(sum == targetVal)
			{
				num1 = copy_arr[left];
				num2 = copy_arr[right];
				break;
			}
		}
		
		// Loop through original array to get the index of the found two values
		int[] result = new int[2];
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i] == num1)
			{
				result[0] = i;
			}
			if(arr[i] == num2)
			{
				result[1] = i;
			}
		}
		return result;
	}
	
	// This solution uses hashmap to store each element as key and related index as value
	// This makes finding the related value for each element (to make targetVal) easy
	// Time complexity = O(N)
	// Space complexity = O(N)
	public int[] twoSumHashing(int[] arr, int targetVal)
	{
		HashMap<Integer, Integer> num_map = new HashMap<>();
		
		for(int i=0; i<arr.length; i++)
		{
			int valToFind = targetVal - arr[i];
			if(num_map.containsKey(valToFind))
			{
				return new int[] {num_map.get(valToFind), i};
			}
			else
			{
				num_map.put(arr[i], i);
			}
		}
		throw new IllegalArgumentException("No two sum solution!!");
	}
	
	// Function to return array elements list as string
	public String printArray(int[] arr)
	{
		String arrStr = "";
		for(int i=0; i<arr.length; i++)
		{
			arrStr = arrStr + arr[i] + " ";
		}
		return arrStr;
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
		System.out.print("Enter target value:");
		int targetVal = sc.nextInt();
		sc.close();
		
		TwoSums ts = new TwoSums();
		
		System.out.println("Result using brute force: "+ts.printArray(ts.twoSumBruteForce(inputArr, targetVal)));
		System.out.println("Result using sorting: "+ts.printArray(ts.towSumSorting(inputArr, targetVal)));
		System.out.println("Result using hash table: "+ts.printArray(ts.twoSumHashing(inputArr, targetVal)));
	}
	
}
