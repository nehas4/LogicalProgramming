package LeetCodePractice.Arrays;


/*
 * [LeetCode 238]
 * 
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 * */
public class ProductOfArrayExceptSelf {
	
	// For this solution maintain a left and right array where left or right side product of i will be saved at i
	// Then for result just return product of both of these arrays
    public int[] productExceptSelf(int[] nums) {
    	
    	int[] left = new int[nums.length];
    	int[] right = new int[nums.length];
        
    	// save left side product at each index
    	left[0] = 1;
    	for(int i=1; i<nums.length; i++)
    	{
    		left[i] = left[i-1] * nums[i-1];
    	}
    	
    	// save right side product at each index
    	right[nums.length-1] = 1;
    	for(int i=nums.length-2; i>=0 ; i--)
    	{
    		right[i] = right[i+1] * nums[i+1];
    	}
    	
    	// Create final result
    	for(int i=0; i<nums.length; i++)
    	{
    		nums[i] = left[i] * right[i];
    	}
    	return nums;
    }
    
    private String printArr(int[] nums)
    {
    	String strArr = "";
    	for(int n : nums)
    	{
    		strArr = strArr + n + " ";
    	}
    	return strArr;
    }
    
    // Faster way to do above
    // Here we are maintaining one result array
    // In the first loop (from start to last) we are saving all the left side product  in result
    // In second loop (from last to start) we are calculating right side product and multiply with result value to get result final value
    public int[] productExceptSelfFaster(int[] nums) {
    	
    	int[] result = new int[nums.length];
        
    	// Calculate left side product first
    	int product = 1;
    	for(int i=0; i<nums.length; i++)
    	{
    		result[i] = product;
    		product = product * nums[i];
    	}
    	
    	// Calculate right side of product now to get final array
    	product = 1;
    	for(int i=nums.length-1; i>=0; i--)
    	{
    		result[i] = result[i] * product;
    		product = product * nums[i];
    	}
    	
    	return result;
    }
    
    
    public static void main(String[] args) {
		int[] inputArr = new int[] {1,2,3,4};
		ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
		System.out.println("Product of array is: "+obj.printArr(obj.productExceptSelfFaster(inputArr)));
	}

}
