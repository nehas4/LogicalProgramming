package LeetCodePractice.Arrays;

public class JumpGame {
	
	// Given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position. Return true if you can reach the last index, or false otherwise.
	public boolean canJump(int[] nums) {
		// Initially the final position is the last index
        int final_idx = nums.length-1;
        
     // Start with the second last index
        for(int i=nums.length-2; i>=0; i--)
        {
            // If you can reach the final position from this index
            // update the final position flag
        	if(i+nums[i] >= final_idx)
        	{
        		final_idx = i;
        	}
        }
        
        // If we reach the first index, then we can make the jump possible
        return final_idx == 0;
    }
	
	public static void main(String[] args) {
		int[] inputArr = new int[] {2,3,1,1,4};
		JumpGame jg = new JumpGame();
		System.out.println("Result of the array can jump game is: "+jg.canJump(inputArr));
	}

}
