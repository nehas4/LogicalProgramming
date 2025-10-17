package LeetCodePractice.Arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * [LeetCode 78]
 * 
 * This is a backtracking problem.
 * Given an array of unique elements, find the total subsets that can be possibly made. 
 * To find these subsets, you need to decide whether you should pick an element or leave it. 
 * Making this choice for each elements creates a state space tree and you then derive your solution.
 * Backtracking makes this easy.
 * Note: Array does not have duplicates
 * 
 * 
 * Time complexity: O(N(2^N))
 * Space complexity: o(N)
 * 
 * */
public class Subsets1 {
	
	// Function to get subsets result by calling the backtracking method with required empty lists to start the backtrack process from scratch
    public List<List<Integer>> subsets(int[] nums) {
        
    	//Result list to maintain the list of subsets
        List<List<Integer>> result = new ArrayList<>();
        // Temp list to maintain the current subset while processing
        List<Integer> tmpList = new ArrayList<>();

        // Calling backtrack function to start with arguments: given array, result list, temp list, start index:0
        backtrack(nums, result, tmpList, 0);

        return result;

    }

    // Function to backtrack in an array to get all possible subsets
    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> tmpList, int i)
    {
    	// Add current temp list into array
        result.add(new ArrayList<>(tmpList));
        
        // Loop through each number in the given array
        for(int j=i; j<nums.length; j++)
        {
        	// Add current number in temp list, to get subset including this element
            tmpList.add(nums[j]);
            // Call backtrack function to backtrack on the current on the subset with other values choices
            backtrack(nums, result, tmpList, j+1);
            // Remove the current number, to get subset excluding this element
            tmpList.remove(tmpList.size()-1);
        }
    }
    
    public static void main(String[] args) {
    	
    	int[] nums = {1,2,3};
    	Subsets1 subsets = new Subsets1();
    	List<List<Integer>> result = subsets.subsets(nums);
    	
    	for(List<Integer> curr_subset : result)
    	{
    		System.out.print("{");
    		
            // Loop using an index 'i' to determine the last element
            for (int i = 0; i < curr_subset.size(); i++) {
                System.out.print(curr_subset.get(i));

                // ONLY print the comma and space if it is NOT the last element
                if (i < curr_subset.size() - 1) {
                    System.out.print(", ");
                }
            }
            
    		System.out.println("}");
    	}
    	
	}

}
