package LeetCodePractice.Arrays;

/*
 * [LeetcCode 152]
 * 
 * Given an integer array, find the contiguous sub-array with he largest product.
 * Array can contain negative numbers.
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 * 
 * */
public class MaximumProductSubarray {
	
	/*
	 * This problem has following different cases (types of element present in array):
	 * - Case 1: All positive numbers or all negative numbers.
	 * - Case 2: Both positive and negative numbers.
	 * 		- Even count of negative numbers.
	 * 		- Odd count of negative numbers.
	 * - Case 3: Positive, negative numbers and 0
	 * 
	 * For case 1, we just need to get the product of all numbers.
	 * Even in the case of even number of negative numbers, product of all the numbers will be the answer.
	 * 
	 * We need to take of that case where there are odd number of negative numbers.
	 * To solve this we will use Kadane's algorithm. We will traverse from left and right and will maintain the current largest sum.
	 * In case of any 0 found in between, consider product till that as 1 and move forward to tackle the sub-array after that 0 element.
	 * */
    public int maxProduct(int[] nums) {
    	
    	int rightProd = nums[0];
    	int leftProd = nums[nums.length - 1];
    	int result = Math.max(rightProd, leftProd);
    	
    	for(int i=1; i<nums.length; i++)
    	{
    		// If any of the left or right product becomes 0, the update it to 1
    		rightProd = rightProd == 0 ? 1 : rightProd;
    		leftProd = leftProd == 0 ? 1 : leftProd;
    		
    		rightProd = rightProd * nums[i]; // Product of all numbers from left side
    		leftProd = leftProd * nums[nums.length - 1 - i]; // Product of all numbers from right side
    		
    		result = Math.max(result, Math.max(rightProd, leftProd)); // Retain maximum product, either current result or max between left or right product
    	}
    	
        return result;
    }
    
    public static void main(String[] args) {
		
    	int[] nums = {2,3,-2,4};
    	
    	MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
    	System.out.println("Maximum product of sub-array for given array is "+maximumProductSubarray.maxProduct(nums));
	}

}
