package LeetCodePractice.Arrays;

/*
 * [LeetCode 198]
 * 
 * Given an array that determines the money stored in each house.
 * Find maximum money which can robbed such that no two adjacent houses are robbed.
 * This problem can be solved with Dynamic Programming efficiently
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 * */
public class HouseRobberProblem1 {
	
    public int rob(int[] nums) {
    	
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
		
    		int[] nums = {2,7,9,3,1};
    		HouseRobberProblem1 houseRobberProblem1 = new HouseRobberProblem1();
    		System.out.println("Maximum loot possible for given set of house values is "+houseRobberProblem1.rob(nums));
	}
}
