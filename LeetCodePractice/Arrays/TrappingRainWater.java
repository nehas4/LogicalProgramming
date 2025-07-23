package LeetCodePractice.Arrays;

// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
public class TrappingRainWater {
	
	// For this solution maintain 2 pointers left and right
	// Loop through heights and at each point get the maxL and maxR
	// Whatever is less that time, get the trapped water that side by doing max-height, then move that side pointer forward
    public int trap(int[] height) {

        int water = 0;
        int n = height.length;
        int lMax = height[0];
        int rMax = height[n-1];
        int l=0, r=n-1;

        while(l<r)
        {
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);

            if(lMax < rMax)
            {
                water += lMax - height[l];
                l++;
            }
            else
            {
                water += rMax - height[r];
                r--;
            }
        }
        return water;
    }
}
