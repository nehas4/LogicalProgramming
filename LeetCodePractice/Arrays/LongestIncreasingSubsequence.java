package LeetCodePractice.Arrays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

/*
 * [LeetCode 300]
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * NOTE: Sequence means increasing numbers in array going from left to right not necessarily being consecutive.
 * 
 * This example of Dynamic programming using Memorization
 * 
 * Time Complexity: O(N^2)
 * Space Complexity: O(N)
 * */
public class LongestIncreasingSubsequence {
	
	
	/*
	 * In this solution we maintain one helper array that will store the longest length of sequence at till each index
	 * Use 2 pointers, one will move forward to evaluate the sequence length at the index, 
	 * other to check from starting index till the current index each time for the sequence
	 * 
	 * At the end loop through the temp array and get the maximum length of the sequence possible at any index
	 * 
	 * */
    public int lengthOfLIS(int[] nums) {
    	
    	int[] tmp = new int[nums.length]; // Helper array to store longest sequence length at each index
    	
    	for(int i=0; i<nums.length; i++) // Left pointer to evaluate the longest sequence till that point
    	{
    		for(int j=0; j<i; j++) // Right pointer to check from start each value till left pointer for the sequence
    		{
    			if(nums[i] > nums[j]) // Compare the left and right pointer value
    			{
    				// If left pointer value (length till left pointer) + 1 is greater then take that value
    				tmp[i] = Math.max(tmp[i], tmp[j]+1); // Update the longest sequence length at point
    			}
    		}
    	}
    	
    	int maxLen = 0;
    	// Loop through temp array to get the longest length
    	for(int i=0; i<nums.length; i++)
    	{
    		maxLen = Math.max(maxLen, tmp[i]);
    	}
        
    	return maxLen + 1; // Adding one to count the self (1 for each index) also as part of subsequence
    }
    
    
    /*
     * This function returns the values of longest Increasing sequence in the given array
     * In order to do so we are using another helper array to store the index of previous value in the currently evaluated sequence
     * */
    public List<Integer> getLongestIncrSeq(int[] nums) {
    	
    	
    	int[] tmpArr = new int[nums.length];
    	int[] tmpSeqArr = new int[nums.length]; // Temp array to store the index of previous value in current sequence
    	
    	int MaxLen = 0;
    	int MaxLenIdx = 0;
    	for(int i=0; i<nums.length; i++)
    	{
    		for(int j=0; j<i; j++)
    		{
    			if(nums[i] > nums[j])
    			{
    				if(tmpArr[j] + 1 > tmpArr[i])
    				{
    					tmpArr[i] = tmpArr[j] + 1;
    					// If sequence length is updated (as current value is greater that left pointer value)
    					// then add the index of previous number in the current index of temp array
    					tmpSeqArr[i] = j;
    					if(tmpArr[i] > MaxLen)
    					{
    						MaxLen = tmpArr[i];
    						MaxLenIdx = i; // Value to store the index where we found the maximum length sequence
    					}
    				}
    			}
    		}
    	}
    	
    	List<Integer> result = new ArrayList<>(); // to store the values of longest sequence
    	result.add(nums[MaxLenIdx]); // Adding the last value of the sequence
    	int lastIdx = MaxLenIdx; // update the last index (already added value) with current index in the sequence
    	MaxLenIdx = tmpSeqArr[MaxLenIdx]; // Update the current max len index with the index of previous number in the temp array 
    	while(tmpSeqArr[MaxLenIdx] != lastIdx) // loop until the previous number is not same as lastIdx
    	{
    		result.addFirst(nums[MaxLenIdx]);
    		lastIdx = MaxLenIdx; // Update the last index evaluated
    		MaxLenIdx = tmpSeqArr[MaxLenIdx]; // Get the new index of previous number
    	}
    	
    	return new ArrayList<>(result);
    	
    }
    
    public static void main(String[] args) {
		
    	int[] nums = {3,4,-1,0,6};
    	
    	LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
    	System.out.println(longestIncreasingSubsequence.lengthOfLIS(nums));
    	
    	List<Integer> result = longestIncreasingSubsequence.getLongestIncrSeq(nums);
    	for(int n : result)
    	{
    		System.out.print(n + " ");
    	}
    	
	}

}
