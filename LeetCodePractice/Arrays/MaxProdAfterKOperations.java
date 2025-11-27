package LeetCodePractice.Arrays;

import java.util.PriorityQueue;

/*
 * [LeetCode 2233]
 * 
 * Given an array of positive integers and utmost k operations. In every operation you can pick one element and increase it by 1.
 * Find maximum product possible after k operations.
 * 
 * Time Complexity: O(nLogn)
 * Space Complexity: O(n)
 * */
public class MaxProdAfterKOperations {
	
	/*
	 * Since we can increment any number in k operations, we need to choose the smallest value number.
	 * As per math behind this, we need to increment the smallest value each time in k operations to get maximum product.
	 * We need to pick and increment smallest value in loop for k times.
	 * For this efficient approach would be using a priority queue as it has property of giving the smallest element when we pop out element.
	 * Add all the elements to priority queue.
	 * 
	 * Here we are using Greedy approach
	 * 
	 * */
    public int maximumProduct(int[] nums, int k) {
    	
    	
    	PriorityQueue<Integer> pq = new PriorityQueue<>();  // Create Priority queue
    	int mod = 1000000007; // having mod value to get mod of product to handle bigger product results
    	
    	// Add all elements to priority queue
    	for(int num : nums)
    	{
    		pq.offer(num);
    	}
    	
    	// Loop k times to perform k operations
    	for(int i = 0; i < k; i++)
    	{
    		// Get minimum element and increment it
    		int curr_min_val = pq.remove();
    		curr_min_val++;
    		
    		pq.offer(curr_min_val); // Add incremented value back to priority queue
    	}
    	
    	
    	long product = 1;
    	// Loop through all the elements to get the product of all the elements
    	while(!pq.isEmpty())
    	{
    		product *= pq.poll(); // Multiple each value
    		product %= mod; // Mod with 10^9 + 7
    	}
    	
    	return (int) product;
    	
    }
    
    public static void main(String[] args) {
		
    	int[] nums = {6,3,3,2};
    	int target = 2;
    	
    	MaxProdAfterKOperations maxProdAfterKOperations = new MaxProdAfterKOperations();
    	System.out.println(maxProdAfterKOperations.maximumProduct(nums, target));
    	
	}

}
