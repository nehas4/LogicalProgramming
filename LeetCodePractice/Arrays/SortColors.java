package LeetCodePractice.Arrays;


/*
 * [LeetCode 75]
 * 
 * Given an array nums with n objects colored red, white, or blue, 
 * sort them in-place so that objects of the same color are adjacent, 
 * with the colors in the order red, white, and blue.
 * Integers 0, 1, and 2 represents the color red, white, and blue, respectively.
 * Solve this problem without using the library's sort function.
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 * 
 * */
public class SortColors {
	
	// In order to do inplace sprting, maintain 3 pointers - start, mid, end
	// We have to check mid pointer in the loop and if its 0 then swap it with start pointer, 
	// if its 2 then swap with end, else if 0 then dont do anything
	// Increment/decrement the pointers based on the swapping
    public void sortColors(int[] nums) {
        
        int start = 0;
        int mid = 0;
        int end = nums.length - 1;

        while(mid <= end)
        {
            switch(nums[mid])
            {
                case 0:
                    swap(nums,start,mid);
                    start++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums,mid,end);
                    end--;
                    break;
            }
        }
    }

    private void swap(int[] nums, int pos1, int pos2)
    {
        int tmp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = tmp;
    }

}
