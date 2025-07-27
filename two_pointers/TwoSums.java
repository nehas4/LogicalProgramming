package two_pointers;

/*
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * 
 * */
public class TwoSums {
	
	// This function returns 2 indexes in a given array which has sum equal to given target
    public int[] twoSum(int[] numbers, int target) {
        
    	// Maintain 2 pointers, one to point start of the array and other to point at the end of array
    	int[] result = new int[2];
    	int i = 0, j = numbers.length - 1;
    	
    	while(i < j)
    	{
    		// Get current indexes sum
    		int curr_sum = numbers[i] + numbers[j];
    		// If sum is equal to target, return the 2 indexes result
    		if (curr_sum == target)
    		{
    			result[0] = i+1;
    			result[1] = j+1;
    			return result;
    		}
    		// If sum is greater than target, decrement second pointer j, as array is in ascending order so, try to check smaller value
    		else if (curr_sum > target)
    		{
    			j--;
    		}
    		else
    		{
    			i++;
    		}
    	}
    	
    	return result;
    }
    
    
    public static void main(String[] args) {
		
    	int[] inputArr = {2,3,4};
    	int target = 6;
    	
    	TwoSums twoSums = new TwoSums();
    	int[] result = twoSums.twoSum(inputArr, target);
    	System.out.println("Two indexes which sum to target are "+result[0]+" and "+result[1]);
	}

}
