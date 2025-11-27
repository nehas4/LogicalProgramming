package LeetCodePractice.Arrays;

/*
 * [LeetCode 1004]
 * 
 * Given a binary array, that contains only 0 and 1. 
 * Determine the maximum consecutive 1s that can be obtained by flipping atmost 'k' zeroes.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * 
 * */
public class MaxConsecutiveOnes3 {
	
	
	/*
	 * In this solution we will use 2 pointers, to point to start and end of current window.
	 * Loop through array and move the end pointer ahead while checking each value.
	 * If current value is 0, then increment the zeros_cnt variable.
	 * Then check if current zeroes count is more than allowed flipping, 
	 * then move the start counter ahead while checking if the start values are 0s, hence decrementing 0s until its not more than k.
	 * At the end end - start of the window will give count of total 1s in the current window including flipped ones also.
	 * 
	 * */
    public int longestOnes(int[] nums, int k) {
    	
    	int max_ones = 0;
    	int start = 0;
    	int zero_cnt = 0;
    	
    	for(int end = 0; end < nums.length; end++)
    	{
    		if(nums[end] == 0) // Check if current value is 0, then increment zeroes counter
    		{
    			zero_cnt++;
    		}
    		
    		// If zeroes count is more than k then move start pointer until zeroes count is less or equal to k
    		while(zero_cnt > k)
    		{
    			// If start value is 0, then remove this element in the current window, decrementing the zeroes counter and moving start pointer
    			if(nums[start] == 0)
    			{
    				zero_cnt--;
    			}
    			start++;
    		}
    		
    		// Update the max one based on the current window length
    		max_ones = Math.max(max_ones, end - start + 1);
    	}
    	
    	return max_ones;
        
    }
    
    public static void main(String[] args) {
		
    	int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
    	int k = 2;
    	
    	MaxConsecutiveOnes3 consecutiveOnes3 = new MaxConsecutiveOnes3();
    	System.out.println(consecutiveOnes3.longestOnes(nums, k));
	}

}
