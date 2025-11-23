package LeetCodePractice.Arrays;

/*
 * [LeetCode 1539]
 * 
 * Given an array of positive integers in an increasing order. Determine the Kth missing number.
 * 
 * Time Complexity: O(logN)
 * Space Complexity: O(1)
 * 
 * */
public class KthMissingPositiveNum {
	
	/*
	 * We are using binary search algorithm to find the indices between with the missing Kth number will be found
	 * We are checking that at any point during the search difference between mid value and mid index is less than k and based on it update left and update pointers
	 * We take advantage of the fact that if there is no missing number in between then the index+1 and value at that index will be same.
	 * So we take the difference between the index and its value and if its greater than 0 then check the Kth missing number
	 * */
    public int findKthPositive(int[] arr, int k) {
    	
    	int left = 0;
    	int right = arr.length;
    	
    	while(left < right)
    	{
    		int mid = left + (right - left)/2;
    		
    		if(arr[mid] - mid - 1 < k) // Check if there is difference between the mid index and its value
    		{
    			left = mid + 1; // Update left index if the missing number difference is less than k for current mid index
    		}
    		else
    		{
    			right  = mid; // Update right pointer if missing numbers for current index mid index is more than k
    		}
    	}
        
    	return left + k; // return missing number by adding k with the left index
    }
    
    
    public static void main(String[] args) {
		
    	int[] arr = {2,3,4,7,11};
    	int k = 5;
    	
    	KthMissingPositiveNum kthMissingPositiveNum = new KthMissingPositiveNum();
    	System.out.println(kthMissingPositiveNum.findKthPositive(arr, k));
	}

}
