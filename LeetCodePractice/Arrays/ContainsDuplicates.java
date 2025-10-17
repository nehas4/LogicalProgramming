package LeetCodePractice.Arrays;

import java.util.HashSet;
import java.util.Set;

/*
 * [LeetCode 217]
 * 
 * Given an integer array, return true if any value appears at least twice in the array, 
 * and return false if every element is distinct.
 * 
 * For this solution we are using HashSet
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 * 
 * */
public class ContainsDuplicates {
	
	// By using HashSet data structure we can check if there are any duplicates as set does not allow any duplicate value entry
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> numsSet = new HashSet<>();

        for(int num : nums)
        {
            boolean flag = numsSet.add(num);
            if(!flag)
            {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
		
    	int[] nums = {1,2,4,2,5};
    	ContainsDuplicates containsDuplicates = new ContainsDuplicates();
    	System.out.println("Array contains duplicates: "+containsDuplicates.containsDuplicate(nums));
	}

}
