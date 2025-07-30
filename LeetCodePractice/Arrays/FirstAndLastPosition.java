package LeetCodePractice.Arrays;

/*
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * */
public class FirstAndLastPosition {
	
	// Function to get the first and last index of target value
	// For this call function to return left bound index using binary search as its a sorted array
	// Also call function to return right bound index using binary search as its a sorted array
    public int[] searchRange(int[] nums, int target) {
    	
    	// Return -1, -1 if nums length is 0
    	if(nums.length == 0)
    	{
    		return new int[] {-1, -1};
    	}
    	else if(nums.length == 1)
    	{
    		// If array size is 1, check if that one value is equal to target value then return 0 as first and last index, else return -1
    		if (nums[0] == target)
    		{
    			return new int[] {0, 0};
    		}
    		else
    		{
    			return new int[] {-1, -1};
    		}
    	}
    	// Calling function to return first occurrence using binary search
    	int first_index = findLeftBound(nums, target);
    	// Calling function to return last occurrence using binary search
    	int last_index = findRightBound(nums, target);
    	
    	return new int[] {first_index, last_index};
    }
    
    // Function to return left bound index
    private int findLeftBound(int[] nums, int target)
    {
     	int index = -1;
    	int left = 0;
    	int right = nums.length-1;
    	
    	while(left <= right)
    	{
    		int mid = left + (right-left)/2;
    		
    		// If we get the target, still continue to check left sub-array to get the first occurrence, hence do right = mid - 1
    		if(nums[mid] == target)
    		{
    			index = mid;
    			right = mid - 1;
    		}
    		else if (nums[mid] > target)
    		{
    			right = mid - 1;
    		}
    		else
    		{
    			left = mid + 1;
    		}
    	}
    	return index;
    }
    
    // Function to get right bound index of the target value
    private int findRightBound(int[] nums, int target)
    {
    	int index = -1;
    	int left = 0;
    	int right = nums.length-1;
    	
    	while(left <= right)
    	{
    		int mid = left + (right-left)/2;
    		
    		// If we get the target, still continue to check right sub-array to get the last occurrence, hence do left = mid + 1
    		if(nums[mid] == target)
    		{
    			index = mid;
    			left = mid + 1;
    		}
    		else if (nums[mid] > target)
    		{
    			right = mid - 1;
    		}
    		else
    		{
    			left = mid + 1;
    		}
    	}
    	return index;
    }
    
    
    public static void main(String[] args) {
		
    	int[] nums = new int[] {5,7,7,8,8,10};
    	int target = 8;
    	
    	FirstAndLastPosition firstAndLastPosition = new FirstAndLastPosition();
    	int[] result = firstAndLastPosition.searchRange(nums, target);
    	System.out.println("First occurrence is found at "+result[0]+" and last occurence found at "+result[1]);
	}

}
