package LeetCodePractice.Arrays;


/*
 * [LeetCode 485]
 * 
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * 
 * */
public class MaxConsecutivOnes {
	
	/*
	 * Maintain 2 variables one to store the current count of 1s and another to store the max count of 1s
	 * In this problem 0 act as the separator between  different consecutive 1s
	 * We loop through the given array and check if its a 1 or 0, if its 1 then increment current count and also update max count
	 * */
    public int findMaxConsecutiveOnes(int[] nums) {
        
    	int curr_cnt = 0;
    	int max_cnt = 0;
    	
    	for(int num : nums)
    	{
    		if(num == 1)
    		{
    			curr_cnt++;
    		}
    		else
    		{
    			curr_cnt = 0;
    		}
    		
    		max_cnt = Math.max(max_cnt, curr_cnt);
    	}
    	
    	return max_cnt;
    }

    public static void main(String[] args) {
		
    	int[] num = {1,1,0,1,1,1};
    	
    	MaxConsecutivOnes consecutivOnes = new MaxConsecutivOnes();
    	System.out.println(consecutivOnes.findMaxConsecutiveOnes(num));
	}
}
