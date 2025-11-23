package LeetCodePractice.Arrays;


/*
 * [LeetCode 45]
 * 
 * Given an array, where each element  the maximum jump possible, determine the minimum jumps, required to reach the last step.
 * This is an example of Greedy Approach problem
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * */
public class JumpGame2 {

	/*
	 * In this solution at each point we check what the maximum steps we can take and consider it as current coverage
	 * Looping through each step we check if get a greater coverage.
	 * We check if current index is equal to lastIndex of earlier coverage, then update the total jumps and last index as current coverage
	 * */
    public int jump(int[] nums) {

        int destination = nums.length-1; // destination to reach with minimum jumps
        int lastJumpIdx = 0; // Last index of coverage
        int coverage = 0; // Reached index after taking maximum steps from current point
        int totalJumps = 0; // Total jumps taken

        if (nums.length == 1)
        {
            return 0;
        }
        
        // Looping through each steps
        for(int i=0; i<nums.length-1; i++)
        {
        	// Check if current index and its allowed steps are greater than current coverage, then update coverage
            coverage = Math.max(coverage, i+nums[i]);

            // If current index and last jump index is equal, then update total jumps and coverage
            if(i == lastJumpIdx)
            {
                lastJumpIdx = coverage; // Update the last jump index as the current coverage index 
                totalJumps++; // Update total jumps as we covered the coverage

                // If current coverage covers the destination also then return the total jumps
                if(coverage >= destination)
                {
                    return totalJumps;
                }
            }
        }
        return totalJumps;
    }
    
    public static void main(String[] args) {
		
    	int[] nums = {2,3,1,1,4};
    	
    	JumpGame2 jumpGame2 = new JumpGame2();
    	System.out.println(jumpGame2.jump(nums));
	}
}