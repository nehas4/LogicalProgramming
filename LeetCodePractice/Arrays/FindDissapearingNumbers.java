package LeetCodePractice.Arrays;

import java.util.ArrayList;
import java.util.List;


/*
 * An integer array of size 'n' contains elements in the range of [ 1, n ] There may or may not be repeating numbers. You need to find the numbers that are disappeared from this range.
 * 
 * */
public class FindDissapearingNumbers {
	
	// This solution is space and time efficient one where we check elements in-place to find the missing elements
	// We first loop through the numbers and take each element value as index and mark that index value by making it negative
	// Once that is done, check which index value is not negative, that index+1 value is missing one so add it in list
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	
    	List<Integer> result = new ArrayList<>();
    	for(int i=0; i<nums.length; i++)
    	{
    		// Take current element value and consider it the index to check and mark
    		int index = Math.abs(nums[i]) - 1;
    		// if value at this index is greater than 0, then make it negative by multiplying it by -1
    		if(nums[index] > 0)
    		{
    			nums[index] *= -1;
    		}
    	}
    	
    	// Loop through the marked array elements and see which index is not marked, then add it in result list
    	for(int i=0; i<nums.length; i++)
    	{
    		if(nums[i] > 0)
    		{
    			result.add(i+1);
    		}
    	}
        
    	return result;
    }

    public static void main(String[] args) {
		
    	int[] nums = new int[] {4,3,2,7,8,2,3,1};
    	
    	FindDissapearingNumbers findDissapearingNumbers = new FindDissapearingNumbers();
    	List<Integer> result = findDissapearingNumbers.findDisappearedNumbers(nums);
    	System.out.println("Disappeared numbers are: ");
    	for(int i : result)
    	{
    		System.out.print(i+" ");
    	}
	}
}
