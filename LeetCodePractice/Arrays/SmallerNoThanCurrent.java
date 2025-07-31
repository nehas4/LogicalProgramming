package LeetCodePractice.Arrays;

/*
 * You are given an array and for each integer you need to find out the number of smaller numbers than itself.
 * */
public class SmallerNoThanCurrent {
	
	// In this solution we use counting sort algorithm, where maintain a frequency/count array to save each values's occurrence number
	// Then update each index count with count till previous
	// Then number of values smaller than current value is saved at that nums value index in count array 
    public int[] smallerNumbersThanCurrent(int[] nums) {
    	
    	// Create buckets for counting sort
    	int[] count = new int[101];
    	
    	for(int i : nums)
    	{
    		count[i]++;
    	}
    	
    	// Get frequency of each element
    	for(int i=1; i<count.length; i++)
    	{
    		count[i] += count[i-1];
    	}
    	
    	// Populate result
    	int[] result = new int[nums.length];
    	for(int i=0; i<nums.length; i++)
    	{
    		if(nums[i] == 0)
    		{
    			result[i] = 0;
    		}
    		else
    		{
    			result[i] = count[nums[i]-1];
    		}
    	}
    	
    	return result;
    }
    
    public static void main(String[] args) {
		
    	int[] nums = new int[] {8,1,2,2,3};
    	
    	SmallerNoThanCurrent smallerNoThanCurrent = new SmallerNoThanCurrent();
    	int[] result = smallerNoThanCurrent.smallerNumbersThanCurrent(nums);
    	System.out.println("For given array below is the count of numbers less than the current one at its index: ");
    	for(int i : result)
    	{
    		System.out.print(i+" ");
    	}
    }
}
