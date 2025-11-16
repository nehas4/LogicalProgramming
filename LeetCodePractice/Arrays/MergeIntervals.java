package LeetCodePractice.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * [LeetCode 56]
 * 
 * Given an array of intervals, merge all the overlapping intervals. Return a n array of non-overlapping intervals.
 * 
 * Time Complexity: 
 * Space Complexity: 
 * 
 * */
public class MergeIntervals {
	
	
	// In this solution sort the intervals array based on the first value
	// Maintain the current range and loop through each interval and check if current interval first value is less than current range last value,
	// then update the range value
	// Else add the final range in result and update the current range with new interval
    public int[][] merge1(int[][] intervals) {
    	
    	Arrays.sort(intervals, Comparator.comparingInt(i -> i[0])); 
    	
    	List<int[]> result = new ArrayList<>(); // Store result in this
    	
    	int[] curr_range = intervals[0]; // Initialize the first interval as current range
    	for(int[] curr_interval : intervals)
    	{
    		if(curr_interval[0] <= curr_range[1]) // Check if current interval is in the range of current-range
    		{
    			if(curr_interval[1] >= curr_range[1])
    			{
    				curr_range[1] = curr_interval[1]; // Update the range value
    			}
    		}
    		else
    		{
    			result.add(curr_range);
    			curr_range = curr_interval; // Get new range
    		}
    	}
    	result.add(curr_range); // Add the last created range value
        
    	return result.toArray(new int[result.size()][]);
    }
    
    
    
    // This solution is similar to above, only difference is that we add the new interval in the list first 
    // and then make changes in the new interval range value based on conditions
    public int[][] merge2(int[][] intervals) {
    	
    	if(intervals.length <= 1)
    	{
    		return intervals;
    	}
    	
    	Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
    	
    	List<int[]> result = new ArrayList<>();
    	int[] newInterval = intervals[0];
    	result.add(newInterval);
    	
    	for(int[] interval : intervals)
    	{
    		if(interval[0] <= newInterval[1])
    		{
    			newInterval[1] = Math.max(interval[1], newInterval[1]);
    		}
    		else
    		{
    			newInterval = interval;
    			result.add(newInterval);
    		}
    	}
    	
    	return result.toArray(new int[result.size()][]);
    }
    
    public static void main(String[] args) {
		
    	int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
    	//int[][] intervals = {{1,4},{4,5}};
    	MergeIntervals mergeIntervals = new MergeIntervals();
    	int[][] result = mergeIntervals.merge2(intervals);
    	for(int[] interval : result)
    	{
    		for(int n : interval)
    		{
    			System.out.print(n+" ");
    		}
    		System.out.println();
    	}
	}

}
