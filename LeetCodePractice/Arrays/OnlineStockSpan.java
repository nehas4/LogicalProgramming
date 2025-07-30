package LeetCodePractice.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.
 * 
 * */
public class OnlineStockSpan {
	
	// Maintain a list of prices
	List<Integer> prices;
	
	public OnlineStockSpan()
	{
		this.prices = new ArrayList<>();
	}
	
	// For each new price, add it to list then loop through list prices till now and compare it with current price and get span count
	public int next(int price)
	{
		prices.add(price);
		int count = 0;
		for(int i=prices.size()-1; i>=0; i--)
		{
			if(prices.get(i) > price)
			{
				break;
			}
			count++;
		}
		return count;
	}
	
	
	// This function accepts the array prices and returns the array of relative spans
	// For this we are using stack to save the index of current high price
	public int[] calculateSpans(int[] prices)
	{
		// Return empty span array if no prices available
		if(prices.length == 0)
		{
			return prices;
		}
		
		int[] spans = new int[prices.length];
		Stack<Integer> span_stack_tmp = new Stack<>();
		span_stack_tmp.add(0); // Add first index in the tmp stack
		spans[0] = 1; // First price will always have span = 1
		
		// Loop through each prices starting from the second price value
		for(int i=1; i<prices.length; i++)
		{
			// pop stack value till its less or equal than current price
			while(!span_stack_tmp.empty() && span_stack_tmp.peek() <= prices[i])
			{
				span_stack_tmp.pop();
			}
			
			// Is stack is empty, then return 1 + current index
			if (span_stack_tmp.empty())
			{
				spans[i] = i + 1;
			}
			else
			{
				// get the index of last price which was more than current one and subtract that to current index to get the span
				spans[i] = i - span_stack_tmp.peek();;
			}
			
			// Add current index to stack
			span_stack_tmp.push(i);
		}
		
		return spans;
	}
	
	public static void main(String[] args) {
		
		int[] prices = {100, 80, 60, 70, 60, 75, 85};
		
		OnlineStockSpan stockSpan = new OnlineStockSpan();
		int[] result = stockSpan.calculateSpans(prices);
		System.out.println("Span result is as below:-");
		for(int i : result)
		{
			System.out.print(i+" ");
		}
	}

}
