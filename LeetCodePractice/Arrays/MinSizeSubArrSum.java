package LeetCodePractice.Arrays;


/*
 * [LeetCode 209]
 * 
 * Given an array of positive integers nums and a positive integer target, 
 * return the minimal length of a sub-array whose sum is greater than or equal to target. 
 * If there is no such sub-array, return 0 instead.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * */
public class MinSizeSubArrSum {
	
	/*
	 * In this solution we are using 2 pointer approach.
	 * We are using 2 pointer, to take care of a sub-array window at a time.
	 * We move the high/right pointer in the loop and add its value to current sum.
	 * Check current sum value every time and if its value is more than or equal to target, 
	 * then in the loop remove the the low/left values of window from current sum and  the low pointer until current sum is less than target.
	 * Also get the length of current window sub-array and update the minimum length value accordingly.
	 * */
    public int minSubArrayLen(int target, int[] nums) {
    	
    	int minLenSubarr = Integer.MAX_VALUE; // Initializing minimum length of sub-array with max value in the start
    	int curr_sum = 0; // To hold the current sum of values in current window
    	
    	int low = 0; // left pointer
    	int high = 0; // right pointer
    	
    	while(high < nums.length)
    	{
    		// Add high value in the current sum and then increment its pointer
    		curr_sum += nums[high];
    		high++;
    		
    		// Loop until current sum becomes less than target value
    		while(curr_sum >= target)
    		{
    			int curr_subarr_len = high - low; // Get the current window length
    			minLenSubarr = Math.min(minLenSubarr, curr_subarr_len); // Update the minimum length of the current sub-array
    			
    			curr_sum -= nums[low]; // Remove the left pointer value from current sum
    			low++; // Increment left pointer
    		}
    	}
    	
    	return minLenSubarr;
    }
    
    public static void main(String[] args) {
		
    	int[] nums = {2,3,1,2,4,3};
    	int target = 7;
    	
    	MinSizeSubArrSum minSizeSubArrSum = new MinSizeSubArrSum();
    	System.out.println(minSizeSubArrSum.minSubArrayLen(target, nums));
	}

}
