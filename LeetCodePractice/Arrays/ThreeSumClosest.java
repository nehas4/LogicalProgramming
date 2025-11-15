package LeetCodePractice.Arrays;

import java.util.Arrays;

/*
 * [LeetCode 16]
 * 
 * Given an integer array nums of length n and an integer target, 
 * find three integers in nums such that the sum is closest to target. Return the sum of the three integers.\
 * Assume that each input would have exactly one solution.
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 * */
public class ThreeSumClosest {
	
	// This solution has same logic as 3Sum, with minor changes
	// Start with sorting the array
	// In each loop calculate the current sum and calculate its absolute difference with target (ignoring negative)
	// Compare it with current minimum difference and update it in case it is less
	// Update the result when new minimum difference is obtained
    public int threeSumClosest(int[] nums, int target) {
    	
    	// Sort the array elements
    	Arrays.sort(nums);
    	int resultSum = nums[0] + nums[1] + nums[2]; // Maintain current result sum
    	int minDiff = Integer.MAX_VALUE; // Main the current minimum difference. Initialize it with a MAX value in the start
    	
    	// Loop till element before last three elements, as we are processing next 2 elements in each loop
    	for(int i=0; i<nums.length-2; i++)
    	{
    		int left = i+1; // Pointer to the start of the remaining array
    		int right = nums.length-1; // Pointer to the end of the remaining array
    		
    		// Loop through rest of the array
    		while(left < right)
    		{
    			// Get the current sum of current element and the current left and right element
    			int curr_sum = nums[i] + nums[left] + nums[right];
    			
    			// Compare current sum with target value and move pointers based on that
    			if(curr_sum == target)
    			{
    				return curr_sum;
    			}
    			else if(curr_sum < target)
    			{
    				left++;
    			}
    			else
    			{
    				right--;
    			}
    			
    			// Get the current difference of current sum with the target value
    			int curr_diff = Math.abs(target-curr_sum);
    			// Compare current difference with previous minimum difference, if less then update the minimum difference and result
    			if(curr_diff < minDiff)
    			{
    				minDiff = curr_diff;
    				resultSum = curr_sum;
    			}
    		}
    	}
    	return resultSum;
    }
    
    public static void main(String[] args) {
		
    	int[] nums = {-1,2,1,-4};
    	int target = 1;
    	
    	ThreeSumClosest sumClosest = new ThreeSumClosest();
    	System.out.println("Closest sum to target="+target+" is "+sumClosest.threeSumClosest(nums, target));
	}

}
