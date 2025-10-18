package LeetCodePractice.Arrays;

/*
 * [LeectCode 977]
 * 
 * Given an integer array sorted in non-decreasing order, 
 * return an array of the squares of each number sorted in non-decreasing order.
 * Note: array can contain negative numbers also and square of negative number becomes positive which can disrupt the non-descending order
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 * */
public class SortedSquares {
	
	// This function returns the square of each number in array in sorted way
    public int[] sortedSquares(int[] nums) {
    	
    	int[] result = new int[nums.length];
    	
    	// Square each element in array (it wont necessary be sorted)
    	for(int i=0; i<nums.length; i++)
    	{
    		nums[i] = nums[i] * nums[i];
    	}
    	
    	// Maintain 2 pointers - one pointing to start of the array and other the end of the array
    	int head=0;
    	int tail=nums.length-1;
    	
    	// Loop through square array and compare head and tail elements to add larger one in result array
    	for(int i=nums.length-1; i>=0; i--)
    	{
    		// If head element is larger, add to result and increment head
    		if(nums[head] > nums[tail])
    		{
    			result[i]=nums[head];
    			head++;
    		}
    		// If tail element is larger, add to result and decrement tail
    		else
    		{
    			result[i]=nums[tail];
    			tail--;
    		}
    	}
    	
    	return result;
        
    }
    
    public static void main(String[] args) {
		
    	int[] nums = {-4,-1,0,3,10};
    	SortedSquares sortedSquares = new SortedSquares();
    	int[] result = sortedSquares.sortedSquares(nums);
    	for(int i : result)
    	{
    		System.out.print(i+" ");
    	}
	}

}
