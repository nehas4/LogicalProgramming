package LeetCodePractice.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * [LeetCode 47]
 * 
 * Given a collection of numbers, that might contain duplicates, 
 * return all possible unique permutations in any order.
 * 
 *  Note: Array can have duplicates
 * 
 * Time complexity: O(n(n!)
 * Space complexity: (n)
 * 
 * */
public class Permutations2 {
	
	// Function uses backtracking method to get list of all possible permutations of numbers in an array.
    public List<List<Integer>> permute(int[] nums) {
    	
    	// Sort the current given array
    	// Backtracking on sorted array will also give us same permutations
    	Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    
    /**
     * This function uses backtracking technique to look for all possibilities in an array
     * 
     * @param result
     * @param tmpList
     * @param nums
     */
    private void backtrack(List<List<Integer>> result, List<Integer> tmpList, int[] nums, boolean[] used)
    {
    	// If the current temp list's size is equal to array's size (means all the elements are checked), 
    	// and if current temp list is not already present in result (to avoid the duplicates)
    	// then add it in result list
        if(tmpList.size() == nums.length && !result.contains(tmpList))
        {
            result.add(new ArrayList<>(tmpList));
            return;
        }

        // Loop through all the numbers in the array every time for each element to get permutations if that element is chosen
        for(int i=0; i<nums.length; i++)
        {
        	// If current index element is used then skip it to check other index values
            if(used[i])
            {
                continue;
            }

            // Add the current number to current temp list
            used[i]=true; // set the index flag when adding the number to current temp list
            tmpList.add(nums[i]);
            // call the backtrack function with current temp list containing chosen elements
            backtrack(result, tmpList, nums, used);
            // Remove the current element in temp list, to backtrack for another option
            used[i]=false; // unset the index flag when element is removed from current temp list
            tmpList.remove(tmpList.size()-1);
        }
    }
    
    
    public static void main(String[] args) {
    	
    	int[] nums = {1,1,2};
    	Permutations2 permutations = new Permutations2();
    	List<List<Integer>> result = permutations.permute(nums);
    	
    	for(List<Integer> curr_list : result)
    	{
    		System.out.print("{");
            for (int i = 0; i < curr_list.size(); i++) {
                System.out.print(curr_list.get(i));

                if (i < curr_list.size() - 1) {
                    System.out.print(", ");
                }
            }
            
    		System.out.println("}");
    	}
	}


}
