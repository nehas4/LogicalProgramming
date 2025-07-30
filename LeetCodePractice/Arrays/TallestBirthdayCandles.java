package LeetCodePractice.Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/*
 * Given array of integers representing height of various candles on a cake, return the total count of max height candles
 * 
 * */
public class TallestBirthdayCandles {
	
	// In this solution we use 2 loops one to find the tallest candle and other to find the number of tallest candles
	public int getTallestCandle(int[] candles)
	{
		int max = 0;
		int tallest = Integer.MIN_VALUE;
		
		for(int candle : candles)
		{
			if(candle > tallest)
			{
				tallest = candle;
			}
		}
		
		for(int candle : candles)
		{
			if(candle == tallest)
			{
				max++;
			}
		}
		
		return max;
	}
	
	
	// In this solution we sort the array first, and loop array from end, increment count until the tallest candle value changes
	// If candles number is 0, then return -1
	// If candles length is just 1, then return the count as 1
	// Else do the real processing
	public int getTallestCandle1(List<Integer> candles)
	{
		if(candles.size() == 0)
		{
			return -1;
		}
		else if(candles.size() ==  1)
		{
			return 1;
		}
		else
		{
			Collections.sort(candles);
			int count = Integer.MIN_VALUE;
			int n = candles.size()-1;
			int prev = candles.get(n);
			count = 1;
			for(int i=n-1; i>=0; i--)
			{
				if(candles.get(i) == prev)
				{
					count++;
					prev = candles.get(i);
				}
			}
			return count;
		}
	}
	
	
	// In this solution we maintain a Hashmap to store all the candles height as key their count as value
	// Loop through candles, if current candle height is not present in the map, then add it with value as 1
	// else update the current count value
	// Also check if current candle height is greater than the current candle height then update the max
	// At the end return the value of max height candle from map
	public int getTallestCandle2(int[] candles)
	{
		HashMap<Integer, Integer> candleCountMap = new HashMap<>();
		int max = Integer.MIN_VALUE;
		
		for(int candle : candles)
		{
			if(!candleCountMap.containsKey(candle))
			{
				candleCountMap.put(candle, 1);
			}
			else
			{
				candleCountMap.put(candle, candleCountMap.get(candle)+1);
				if(candle > max)
				{
					max = candle;
				}
			}
		}
		
		return candleCountMap.get(max);
	}
	
	public static void main(String[] args) {
		int[] candles = {4,3,2,4,1,4};
		TallestBirthdayCandles tallestBirthdayCandles = new TallestBirthdayCandles();
		System.out.println("Total number of tallest candles are "+tallestBirthdayCandles.getTallestCandle2(candles));
	}

}
