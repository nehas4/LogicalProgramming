package LeetCodePractice.Arrays;

import java.util.Stack;


/*
 * [LeetCode 739]
 * given an array of integers that represent the temperature at that day, 
 * return an array that represents the next warmer day. 
 * Its an extension of finding the Next Greater Element.
 * In this solution instead of saving the value for next greater element, we save its index, 
 * so that we can calculate the days different between 2 current and next greater temperature days.
 * 
 * Time complexity: O(N)
 * Space complexity: O(N)
 * */
public class DailyTemperatures {
	
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] result = new int[n];

        // Maintain a helper stack to save the index of next greater element
        Stack<Integer> helperStk = new Stack<>();
        
        // Loop backwards in given array for temperatures
        for(int i=n-1; i>=0; i--)
        {
        	
        	// Remove elements from stack until top index value in stack is greater than current element in temperatures array
            while(!helperStk.isEmpty() && temperatures[i]>=temperatures[helperStk.peek()])
            {
                helperStk.pop();
            }

            // If stack is not empty, 
            // get the days difference between top index value in stack and current index 
            // and save the days difference in result arrays
            if(!helperStk.isEmpty())
            {
                result[i] = helperStk.peek() - i;
            }

            // Add current index in stack for further process
            helperStk.push(i);
        }
        
        return result;
    }

}
