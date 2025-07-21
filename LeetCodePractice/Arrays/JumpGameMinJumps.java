package LeetCodePractice.Arrays;

public class JumpGameMinJumps {
	
	// Given an array with number of jumps possible at each index as value, return the minimum number of jumps to reach end of array
	// In the below solution we are checking at each index whats the maximum number of jump we can make, then is called coverage
	// Also we maintain the last jump index or last coverage to check when i reach it then update it to current coverage and increment total jumps
    public int jump(int[] nums) {

    	// destination is last index
        int destination = nums.length-1;
        int lastJumpIdx = 0;
        int coverage = 0;
        int totalJumps = 0;

        // Base case
        if (nums.length == 1)
        {
            return 0;
        }
        
        // Greedy strategy: extend coverage as long as possible
        for(int i=0; i<nums.length-1; i++)
        {
            coverage = Math.max(coverage, i+nums[i]);

            if(i == lastJumpIdx)
            {
                lastJumpIdx = coverage;
                totalJumps++;

                // check if we reached destination already
                if(coverage >= destination)
                {
                    return totalJumps;
                }
            }
        }
        return totalJumps;
    }

}
