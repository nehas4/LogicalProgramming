package LeetCodePractice.Arrays;

import java.util.HashMap;
import java.util.Map;


/*
 * [LeetCode ]
 * 
 * Given an array where each element represents a type of fruit. Determine the maximum number of contiguous fruit you can pick
 * such that the basket can have only 2 different type of fruits.
 * Find the length of the longest contiguous sub-array with at most 2 distinct integers.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * */
public class FruitsInBasket {

	
	/*
	 * In this solution we maintain a map of baskets to store the count of fruits in each basket.
	 * We also have 2 pointers left and right which we move forward based on fruits collection in the basket and number of baskets
	 * We loop through each fruit and add it in the basket map with updated count.
	 * If basket size becomes greater than 2 then start decrementing and removing the fruit count in the map from left side fruit until size is again 2
	 * Then the total fruits that can be put in 2 baskets will be difference between right and left index
	 * */
    public int totalFruit(int[] fruits) {

        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxFruitCnt = 0;

        // Loop through the array and move the right pointer one by one
        for(right = 0; right<fruits.length; right++)
        {
        	// Add the current fruit and its related count in basket
            int curr_cnt = basket.getOrDefault(fruits[right],0);
            basket.put(fruits[right], curr_cnt + 1);

            // Loop in basket map until the size is greater than 2
            while(basket.size() > 2)
            {
            	// Get the count of fruit at the left point from map
                int fruit_cnt = basket.get(fruits[left]);
                // If the count is equal to 1, then remove it from the basket, else decrement its count in the map
                // We do this so that at the end of this loop basket size is back to 2 or less
                if(fruit_cnt == 1)
                {
                    basket.remove(fruits[left]);
                }
                else
                {
                    basket.put(fruits[left], fruit_cnt - 1);
                }
                left++;
            }
            
            // Update the maximum fruit count if total current fruits in basket is greater
            maxFruitCnt = Math.max(maxFruitCnt, right-left+1);
        }
        return maxFruitCnt;
    }
    
    /*
     * This is faster solution of this problem
     * In this problem we maintain last and second last fruit count to keep track of 2 baskets and its related fruits
     * In this solution we don't need to use any extra space
     * */
    public int totalFruit1(int[] fruits) {

        int lastFruit = -1; // Last fruit value
        int secondLastFruit = -1; // Second last fruit value
        int lastFruitCnt = 0; // Last fruit count
        int currFruitsCnt = 0; // Current fruits count in both the baskets
        int maxFruitCnt = 0; // Maximum fruits in both the baskets

        // Loop through each fruit
        for(int fruit : fruits)
        {
        	// Check if current fruit is either equal to last or second last fruit.
        	// If yes then update the current fruits count
        	// Else, current fruits count will be 1 more than last fruit count
            if(fruit == lastFruit || fruit == secondLastFruit)
            {
                currFruitsCnt++;
            }
            else
            {
                currFruitsCnt = lastFruitCnt + 1;
            }

            // If current fruit is equal to last fruit, then update the last fruit count
            // Else update the last fruit as current fruit and second-last fruit as previous last fruit
            // Also update the last fruit count as 1
            if(fruit == lastFruit)
            {
                lastFruitCnt++;
            }
            else
            {
                lastFruitCnt = 1;
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }

            // Get the maximum fruits count from all current fruits count
            maxFruitCnt = Math.max(maxFruitCnt, currFruitsCnt);
        }
        return maxFruitCnt;
    }
    
    public static void main(String[] args) {
		
    	int[] fruits = {1,2,3,2,2};
    	
    	FruitsInBasket fruitsInBasket = new FruitsInBasket();
    	System.out.println(fruitsInBasket.totalFruit(fruits));
	}
}