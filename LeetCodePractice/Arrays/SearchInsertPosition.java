package LeetCodePractice.Arrays;

/*
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * */
public class SearchInsertPosition {
	
	// Since its a sorted array and we need to search for some target value, we will use binary search which will give us time complexity of O(logN)
	// We will loop until the value of low and high is same
	// At any point if mid is same as target, return its index, else return the index of low value which we reach after trying to find the target
	// If target value is not found, binary search will lead us to index which has value greater than target and where it should be inserted
    public int searchInsert(int[] nums, int target) {
    	
    	int low=0, high=nums.length-1, mid=0;
    	
    	while(low <= high)
    	{
    		mid = low + (high - low) / 2;
    		
    		if(nums[mid] == target)
    		{
    			return mid;
    		}
    		else if(nums[mid] > target)
    		{
    			high = mid - 1;
    		}
    		else
    		{
    			low = mid + 1;
    		}
    	}
        
    	return low;
    }

    
    public static void main(String[] args) {
		
    	int[] nums = new int[] {1,3,5,6};
    	int target = 5;
    	
    	SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
    	System.out.println("Search or insert position for target value "+target+" is "+searchInsertPosition.searchInsert(nums, target));
	}
}
