package LeetCodePractice.Arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * [LeetCode 46]
 * 
 * Given an array numbers of distinct integers, return all the possible permutations. 
 * You can return the answer in any order.
 * Whenever you get a problem like find all the possibilities, then it means backtracking solution can be used in it
 * Note: Array does not have duplicates
 * 
 * Time complexity: O(n(n!)
 * Space complexity: (n)
 * */
public class Permutations1 {
	
	// Function uses backtracking method to get list of all possible permutations of numbers in an array.
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    
    /**
     * This function uses backtracking technique to look for all possibilities in an array
     * 
     * @param result
     * @param tmpList
     * @param nums
     */
    private void backtrack(List<List<Integer>> result, List<Integer> tmpList, int[] nums)
    {
    	// If the current temp list's size is equal to array's size (means all the elements are checked), 
    	// then add it in result list
        if(tmpList.size() == nums.length)
        {
            result.add(new ArrayList<>(tmpList));
            return;
        }

        // Loop through all the numbers in the array every time for each element to get permutations if that element is chosen
        for(int num : nums)
        {
        	// If current temp list contains the current number then we skip it
            if(tmpList.contains(num))
            {
                continue;
            }

            // Add the current number to current temp list
            tmpList.add(num);
            // call the backtrack function with current temp list containing chosen elements
            backtrack(result, tmpList, nums);
            // Remove the current element in temp list, to backtrack for another option 
            tmpList.remove(tmpList.size()-1);
        }
    }
    
    
    public static void main(String[] args) {
    	
    	int[] nums = {1,2,3};
    	Permutations1 permutations = new Permutations1();
    	List<List<Integer>> result = permutations.permute(nums);
    	
    	for(List<Integer> curr_list : result)
    	{
    		System.out.print("{");
    		
            // Loop using an index 'i' to determine the last element
            for (int i = 0; i < curr_list.size(); i++) {
                System.out.print(curr_list.get(i));

                // ONLY print the comma and space if it is NOT the last element
                if (i < curr_list.size() - 1) {
                    System.out.print(", ");
                }
            }
            
    		System.out.println("}");
    	}
	}

}
