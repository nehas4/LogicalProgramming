package LeetCodePractice.Arrays;


/*
 * [LeetCode 213]
 * 
 * Given an array that determines the money stored in each house.
 * Find maximum money which can robbed such that no two adjacent houses are robbed.
 * Note: The houses are in circular pattern such that last house is adjacent to first house.
 * 
 * Since first and last house and adjacent and we can't loot both of them then we need to check for 2 scenarios
 * - pick the first house for evaluation
 * - pick the last house for evaluation
 * The get the maximum value from both
 * 
 * Evaluation of max loot will be same as House Robber Problem-1        
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 * */
public class HouseRobberProblem2 {
	
    public int rob(int[] nums) {
    	
		// If there is only one house that its value/money is the max loot result
		if(nums.length < 2)
		{
			return nums[0];
		}
		
		// Create new array to store max loot value if we skip last house
		int[] skipLastHouse = new int[nums.length-1];
		// Create new array to store max loot value if we skip first house
		int[] skipFirstHouse = new int[nums.length-1];
		
		// Store the respective values in both arrays
		for(int i=0; i<nums.length-1; i++)
		{
			skipLastHouse[i] = nums[i];
			skipFirstHouse[i] = nums[i+1];
		}
		
		// Get the max loot value evaluated in each scenario by calling the helper function
		int lootSkippingLast = robHelper(skipLastHouse);
		int lootSkippingFirst = robHelper(skipFirstHouse);
		
		// Return the max of the above to values to decide the overall max loot
		return Math.max(lootSkippingLast, lootSkippingFirst);
        
    }
	
    
    // Function to get the maximum loot possible with given set of money values at each index house
    public int robHelper(int[] nums) {
    	
		// If there is only one house that its value/money is the max loot result
		if(nums.length < 2)
		{
			return nums[0];
		}
    	
		// Maintain a array that contains maximum loot value at current index
		int[] maxLootTillCurrHouse = new int[nums.length];
		
		// Max loot till first value will be same as its value
		maxLootTillCurrHouse[0] = nums[0];
		// Max loot second value will be max of both the houses
		maxLootTillCurrHouse[1] = Math.max(nums[0],nums[1]);
		
		// Loop through rest of the available houses and check at each house which combination will have the max loot value
		for(int i=2; i<nums.length; i++)
		{
			// At each house index either of below 2 are the max loot
			// - combination of last to last house and current house money is the loot
			// - last house value
			// Hence pick the max between two
			maxLootTillCurrHouse[i] = Math.max(maxLootTillCurrHouse[i-2]+nums[i], maxLootTillCurrHouse[i-1]);
		}
		
		// Value at the last index will have the max loot possible till last house
    return maxLootTillCurrHouse[nums.length-1];
    }
    
    public static void main(String[] args) {
		
		int[] nums = {1,2,3,1};
		HouseRobberProblem1 houseRobberProblem1 = new HouseRobberProblem1();
		System.out.println("Maximum loot possible for given set of house values is "+houseRobberProblem1.rob(nums));
    }

}
