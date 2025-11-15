package two_pointers;

/*
 * [LeetCode 15]
 * 
 * Given an integer array nums, return all the triplets (i, j, k) such that nums[i] + nums[j] + nums[k] == 0.
 * Note: Solution set must not contain duplicate triplets.
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 * */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	
	
	// In this solution we are using the concept of 2-sum
	// Sort the array to make the traversal and finding easy
	// Loop through each element and get the current target value to achieve in 2-Sum by getting the different between 0 and the element
	// Then call 2 Sum function by passing the array, current target value and rest of the array index start and end
	// Using Set to store the result to avoid the duplicates
    public List<List<Integer>> threeSum(int[] nums) {
     
    	Set<List<Integer>> result = new HashSet<>();
    	int n = nums.length-1;
    	Arrays.sort(nums);
    	for(int i=0; i<n-1; i++)
    	{
    		int curr_target = 0 - nums[i];
    		Set<List<Integer>> twoSumResult = getTwoSum(nums, i+1, n, curr_target);
    		for(List<Integer> rs : twoSumResult)
    		{
    			result.add(Arrays.asList(nums[i], rs.get(0), rs.get(1)));
    		}
    	}
    	return new ArrayList<>(result);
    }
    
    // In this function we evaluate 2 sum values for a given target value in give array
    // We sort the array first so that we traverse using 2 pointers left and right, pointing to largest and lowest values
    // For each element, check if left and right element sum is equal to target
    // If equal then add to result set and move the pointers forward
    // If current sum is less than target value then move the left pointer forward to look for greater value, as array is sorted
    // Else if current sum is more that target, then move the right pointer backwards to look for smaller value
    private Set<List<Integer>> getTwoSum(int[] nums, int i, int n, int curr_target)
    {
    	Set<List<Integer>> result = new HashSet<>();
    	int left = i;
    	int right = n;
    	while(left < right)
    	{
    		int curr_sum = nums[left] + nums[right];
    		if(curr_sum == curr_target)
    		{
    			result.add(Arrays.asList(nums[left], nums[right]));
    			left++;
    			right--;
    		}
    		else if(curr_sum < curr_target)
    		{
    			left++;
    		}
    		else
    		{
    			right--;
    		}
    	}
    	
    	return result;
    }
    
    
    // This is faster solution of 3Sum problem where we are doing the process in same loop using same logic to maintain 2 pointers
    // Here we maintain the lastLow occurrence and lastHigh occurrence so that, we same value is present further in the loops then we directly move forward in the loop without checking
    public List<List<Integer>> threeSum_faster(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        
        if (nums.length < 3) {
            return answer;
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                break;
            }
            
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum > 0) {
                    high--;
                } else if (sum < 0) {
                    low++;
                } else {
                    answer.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    int lastLowOccurrence = nums[low];
                    int lastHighOccurrence = nums[high];
                    
                    while (low < high && nums[low] == lastLowOccurrence) {
                        low++;
                    }
                    
                    while (low < high && nums[high] == lastHighOccurrence) {
                        high--;
                    }
                }
            }
        }
        return answer;
    }
    
    public static void main(String[] args) {
		
    	int[] inputArr = new int[] {-2,0,1,1,2};
    	
    	ThreeSum threeSum = new ThreeSum();
    	List<List<Integer>> result = threeSum.threeSum(inputArr);
    	System.out.println("Result of 3 sum is as below:");
    	for(List<Integer> list : result)
    	{
    		System.out.println(list.get(0)+" "+list.get(1)+" "+list.get(2));
    	}
	}

}
