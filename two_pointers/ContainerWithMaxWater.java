package two_pointers;

/*
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * 
 * */
public class ContainerWithMaxWater {
	
	// Function to return max area in given array of heights that can store maximum water
    public int maxArea(int[] height) {
    	
    	int max = 0;
    	// Maintain 2 pointers pointing to start and end of array
    	int i = 0, j = height.length - 1;
    	
    	// Loop through array of heights
    	while(i < j)
    	{
    		// Get the max water stored for current height indexes by multiplying the minimum height of i or j and no of indexes in between
    		int currWater =  Math.min(height[i], height[j]) * (j - i);
    		max = Math.max(max, currWater);
    		
    		// whatever height is minimum move that pointer forward
    		if(height[i] > height[j])
    		{
    			j--;
    		}
    		else
    		{
    			i++;
    		}
    	}
    	
    	return max;
    }
    
    
    // Faster way to get max area to store max water
    // It has same logic, except the logic of moving the pointers forward
    public int maxArea_faster(int[] h) {
        int n = h.length;
        int maxArea = 0;

        int left = 0;
        int right = n-1;

        while(left<right){
            int min = Math.min(h[left], h[right]);
            int water = (right-left)*min;
            maxArea = Math.max(water, maxArea);

            // Increment start pointer forward till current left height is less than current minimum
            while(left<right && h[left]<=min) left++;
            // Decrement end pointer backwards till current right height is less than current minimum
            while(left<right && h[right]<=min) right--;
        }

        return maxArea;
    }
    
    public static void main(String[] args) {
		
    	// int[] heights = {1,8,6,2,5,4,8,3,7};
    	int[] heights = {1,1};
    	
    	ContainerWithMaxWater containerWithMaxWater = new ContainerWithMaxWater();
    	System.out.println("Maximum water that can be stored is "+containerWithMaxWater.maxArea(heights));
	}

}
