package LeetCodePractice.Arrays;

import java.util.Scanner;

public class ModifiedBinarySearch {
	
	// This is a modified version of binary search algorithm to search a value in a sorted array which has been rotated by unknown number of times
	// Divide array in sub-arrays and check which sub-array is sorted one, check if target value falls in the range of sorted sub-array and do binary search on the same
	// Else recursively send unsorted sub-array for the same process
	public int modifiedBinarySearch(int[] nums, int targetVal, int left, int right)
	{
		// target value not found
		if(left > right)
		{
			return -1;
		}
		
		int mid = left + ((right -left) / 2);
		if(nums[mid] == targetVal)
		{
			return mid; // target value found
		}
		
		// If left half is sorted
		if(nums[mid] >= nums[left])
		{
			// If target value is in left half
			if(nums[left] <= targetVal && targetVal <= nums[mid])
			{
				return modifiedBinarySearch(nums, targetVal, left, mid-1);
			}
			else
			{
				return modifiedBinarySearch(nums, targetVal, mid+1, right);
			}
		}
		else // If right half is sorted
		{
			// If target value is in right half
			if(nums[mid] <= targetVal && targetVal <= nums[right])
			{
				return modifiedBinarySearch(nums, targetVal, mid+1, right);
			}
			else
			{
				return modifiedBinarySearch(nums, targetVal, left, mid-1);
			}
		}
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
		System.out.print("Enter target value to search:");
		int targetVal = sc.nextInt();
		sc.close();
		
		ModifiedBinarySearch mbs = new ModifiedBinarySearch();
		System.out.println("Target value="+targetVal+" found at index="+mbs.modifiedBinarySearch(inputArr, targetVal, 0, size-1));
	}

}
