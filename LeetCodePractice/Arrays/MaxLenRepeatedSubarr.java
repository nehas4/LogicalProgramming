package LeetCodePractice.Arrays;


/*
 * [LeetCode 718]
 * 
 * Given two integer arrays nums1 and nums2, return the maximum length of a sub array that appears in both arrays.
 * 
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 * 
 * */
public class MaxLenRepeatedSubarr {

	// In this solution we are using a matrix to store if at any index in nums1 and at any index in nums2 values are same
	// Then we loop through each array and check the relates indices value if its same or not
	// If we find the same values then we increment the current matrix position with previous matrix cell index count
    public int findLength(int[] nums1, int[] nums2) {
        // 2D Matrix to store the count of repeated sub array at any point in both the arrays
    	// Note: length or rows and column of the matrix is one more than length of both the arrays as for first row and column, count value will be 0 only
        int[][] matrix = new int[nums1.length + 1][nums2.length + 1];
        int maxSubArrLen = 0;

        // Loop through both the arrays, starting from 1
        for(int i = 1; i <= nums1.length; i++)
        {
            for(int j = 1; j <= nums2.length; j++)
            {
            	// Check i-1 index values in both the arrays and see if its equal
                if(nums1[i-1] == nums2[j-1])
                {
                	// If same value in both he arrays, then get previous (diagonally) count from matrix and store the incremented value
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                }

                // Check if current count is greater than the max length then update the max length
                maxSubArrLen = Math.max(maxSubArrLen, matrix[i][j]);
            }
        }
        return maxSubArrLen;
    }
    
    
    public static void main(String[] args) {
		
    	int[] nums1 = {1,2,3,2,1};
    	int[] nums2 = {3,2,1,4,7};
    	
    	MaxLenRepeatedSubarr maxLenRepeatedSubarr = new MaxLenRepeatedSubarr();
    	System.out.println(maxLenRepeatedSubarr.findLength(nums1, nums2));
	}
}