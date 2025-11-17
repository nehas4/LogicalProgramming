package LeetCodePractice.Arrays;

/*
 * [LeetCode 643]
 * 
 * Given an integer array and an integer 'K'.
 * Find maximum average possible for a  sub-array of size 'K'
 * 
 * This problem can be solved using Sliding Window Algorithm.
 * 
 * Time complexity: 
 * Space complexity: 
 * 
 * */
public class MaxAverageSubarray {
	
	/*
	 * In this solution we start with sum of first k elements.
	 * We have 2 pointers one pointing to the start of the window and one to the end of window (set of elements to check)
	 * We move the pointers in a way to get the sum of different set of k  in the current window.
	 * We move ahead in sliding window fashion, where we remove the start element value and add the end element value, to get the new window sum.
	 * Update the max sum.
	 * At the return the average.
	 * */
    public double findMaxAverage(int[] nums, int k) {
    	
    	// Get sum for the starting window
    	int sum = 0;
    	for(int i=0; i<k; i++)
    	{
    		sum += nums[i];
    	}
    	
    	int maxSum = sum;
    	
    	// Start sliding window
    	int start = 0;
    	int end = k;
    	while(end < nums.length)
    	{
    		sum -= nums[start]; // Remove previous element
    		start++;
    		
    		sum += nums[end]; // Add next element
    		end++;
    		
    		maxSum = Math.max(maxSum, sum); // Update max sum
    	}
        
    	// Return the average
    	return (double) maxSum / k;
    }

    public static void main(String[] args) {
		
    	int[] nums = {1,12,-5,-6,50,3};
    	int k = 4;
    	
    	MaxAverageSubarray maxAverageSubarray = new MaxAverageSubarray();
    	System.out.println("Maximum average of size "+k+" is "+maxAverageSubarray.findMaxAverage(nums, k));
	}
}
