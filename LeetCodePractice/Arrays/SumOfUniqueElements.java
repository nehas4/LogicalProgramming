package LeetCodePractice.Arrays;


/*
 * [LeetCode 1748]
 * 
 * Given an integer array, find the sum of elements that appear exactly once.
 * Note: Constraint 0 < n < 100
 * 
 * Time Complexity: O(n)
 * Complexity: O(1)
 * 
 * */
public class SumOfUniqueElements {
	
	
	/*
	 * For this solution use a frequency array to store the information of frequency of each element
	 * Since we know that values are in the range of 0 to 100, we will maintain a array of 100 size.
	 * In frequency array index will be considered as value in given array and value as its frequency.
	 * Traverse given array and for each value, check that index in frequency array and increment its frequency
	 * Then Loop through the frequency array and sum all the values that have frequency only 1 means unique values
	 * 
	 * */
    public int sumOfUnique(int[] nums) {
    	
    	int[] freq = new int[101]; // Create frequency map
    	
    	// Loop and update related index value frequency
    	for(int num : nums)
    	{
    		freq[num]++;
    	}
    	
    	int sum = 0;
    	// Loop through frequency map and add those value in the sum which has frequency 1
    	for(int i = 0; i < freq.length; i++)
    	{
    		if(freq[i] == 1)
    		{
    			sum += i;
    		}
    	}
    	
    	return sum;
        
    }
    
    
    public static void main(String[] args) {
		
    	int[] nums = {1,2,3,4,5};
    	
    	SumOfUniqueElements sumOfUniqueElements = new SumOfUniqueElements();
    	System.out.println(sumOfUniqueElements.sumOfUnique(nums));
	}

}
