package LeetCodePractice.Arrays;


/*
 * [LeetCode 283]
 * 
 * Given an array of positive integers with some zeroes. 
 * You need to move all the zeroes to the end without changing the relative order of non-zero elements.
 * 
 * Time complexity: O(N)
 * Space complexity: O(1)
 * */
public class MoveZeros {
	
	
	// In this solution we are able to move all the zeros at the end of the array while retaining the order of non-zero elements also, without using extra space or creating extra array
	// Here we will maintain a pointer that will point to current index where we want to insert the next non-zero element
	// Loop through array and don't do anything if zero element found, but move non-zero element at insert pointer index. Also increment insert pointer index
	// Once this loop ends, loop till insert pointer points to end of the array and insert 0 at rest of the indexes
    public void moveZeroes(int[] nums) {
    	
    	int insertAt = 0;
    	
    	for(int i=0; i<nums.length; i++)
    	{
    		if(nums[i] != 0)
    		{
    			nums[insertAt] = nums[i];
    			insertAt++;
    		}
    	}
    	
    	while(insertAt < nums.length)
    	{
    		nums[insertAt] = 0;
    		insertAt++;
    	}
    }
    
    public static void main(String[] args) {
		
    	int[] nums = new int[] {0,1,0,3,12};
    	
    	MoveZeros moveZeros = new MoveZeros();
    	moveZeros.moveZeroes(nums);
    	System.out.println("After moving all the zeros at the end, below is the output array: ");
    	for(int i : nums)
    	{
    		System.out.print(i+" ");
    	}
	}

}
