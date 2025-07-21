package LeetCodePractice.Arrays;

public class BuyAndSellProfit2 {
	
	// Here given an array containing prices of a share at different day, calculate maximum profit by selling and buy shares on different days. Multiple transaction is allowed.
	// For this compare each day price with previous day and if more then calculate the profit between those two
	// Keep on adding the profit if multiple instances found where previous day price was less.
    public int maxProfit(int[] prices) {
        int profit = 0;

        for(int i=1; i<prices.length; i++)
        {
            if(prices[i] > prices[i-1])
            {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }

}
