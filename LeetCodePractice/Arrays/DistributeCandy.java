package LeetCodePractice.Arrays;

import java.util.Arrays;

// There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings. You are giving candies to these children subjected to the following requirements:
//		Each child must have at least one candy.
//		Children with a higher rating get more candies than their neighbors.
// Return the minimum number of candies you need to have to distribute the candies to the children.
public class DistributeCandy {
	
	// In this solution maintain 2 arrays left and right
	// Initialize both the arrays values with 1
	// First check all the left side of ratings of each index and if greater then update the candies for that index to be greater than its left candy
	// Then check all the right side of ratings for each index and if greater then update the candies for that index to be greater than its right candy
	// Then at the end calculate the total candies by adding up the max between left and right for each index
    public int candy(int[] ratings) {
     
    	int[] left = new int[ratings.length];
    	int[] right =  new int[ratings.length];
    	int candies = 0;
    	
    	Arrays.fill(left,1);
    	Arrays.fill(right,1);
    	
    	for(int i=1; i<ratings.length; i++)
    	{
    		if(ratings[i] > ratings[i-1])
    		{
    			left[i] = left[i-1] + 1;
    		}
    	}
    	
    	for(int i=ratings.length-2; i>=0; i--)
    	{
    		if(ratings[i] > ratings[i+1])
    		{
    			right[i] = right[i+1] + 1;
    		}
    	}
    	
    	for(int i=0; i<ratings.length; i++)
    	{
    		candies += Math.max(left[i], right[i]);
    	}
    	return candies;
    }
    
    
    // This is faster solution than above. Here we are maintaining only left side candies check array
    // Initialize left array with 1 value
    // First check all the left side of ratings of each index and if greater then update the candies for that index to be greater than its left candy
    // Then check right side of neighbor and if its greater then take the maximum of current candies (calculate in left check) or incremented right neighbor values
    // Then at the end add up all the value to get total candies
    public int candyFaster(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        }

        int total = 0;
        for (int c : candies)
            total += c;

        return total;
    }
    
    public static void main(String[] args) {
		int[] ratings = new int[] {1,0,2};
		DistributeCandy dc = new DistributeCandy();
		System.out.println("Maximum candies to be distributes is "+dc.candy(ratings));
	}

}
