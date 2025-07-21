package LeetCodePractice.Arrays;

import java.lang.Math;

class BuyAndSellProfit1 {

    // This function loops through array containing prices value at each day (index)
    // purpose is to buy the stocks and sell it on days that can make most profit
    // So maintain 2 pointers - left: pointing low price day, right: pointing to high price day
    // If right price is greater, calculate profit
    // else move left pointer to next low price i.e., current right
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int max_profit = 0;

        while (right < prices.length)
        {
            if (prices[left] < prices[right])
            {
                int profit = prices[right] - prices[left];
                max_profit = Math.max(max_profit, profit);
            }
            else
            {
                left = right;
            }
            right++;
        }
        return max_profit;
    }
}
