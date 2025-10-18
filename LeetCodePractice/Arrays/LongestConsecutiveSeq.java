package LeetCodePractice.Arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * [LeetCode 128]
 * 
 * Given an unsorted array of integers nums, 
 * return the length of the longest consecutive elements sequence.
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 * */
public class LongestConsecutiveSeq {

    public int longestConsecutive(int[] nums) {
     
    	int longestLength=0;
    	
    	// Map to maintain what elements has already been checked
    	Map<Integer, Boolean> exploreMap = new HashMap<Integer, Boolean>();
    	// Loop to initialize explore flag for each element as FLAG in the start
    	for(int num : nums)
    	{
    		exploreMap.put(num, Boolean.FALSE);
    	}
    	
    	for(int num : nums)
    	{
    		int currLength = 1;
    		
    		// Checking the next sequence numbers for current number
    		int nextNum = num + 1;
    		// Set the value in map and count length until next number is in map and is false
    		while(exploreMap.containsKey(nextNum) && exploreMap.get(nextNum) == false)
    		{
    			exploreMap.put(nextNum, Boolean.TRUE);
    			nextNum++;
    			currLength++;
    		}
    		
    		// Checking the previous sequence numbers for current number
    		int prevNum = num - 1;
    		// Set the value in map and count length until previous number is in map and is false
    		while(exploreMap.containsKey(prevNum) && exploreMap.get(prevNum) == false)
    		{
    			exploreMap.put(prevNum, Boolean.TRUE);
    			prevNum--;
    			currLength++;
    		}
    		
    		longestLength = Math.max(longestLength, currLength);
    	}
    	
    	return longestLength;
    }
    
    
    public static void main(String[] args) {
		
    	int[] nums = {100,4,200,1,3,2};
    	LongestConsecutiveSeq consecutiveSeq = new LongestConsecutiveSeq();
    	System.out.print("Longet consecutive sequence is: "+consecutiveSeq.longestConsecutive(nums));
	}
}
