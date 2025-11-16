package LeetCodePractice.Arrays;


/*
 * [LeetCode 74]
 * 
 * Given a m*n integer matrix, which is sorted and the first element of next row is greater than the last element of next row.
 * Return true is target element is present in the matrix.
 * Note: Write a solution in O(log(m * n)) time complexity.
 * 
 * Time complexity: O(log(m*n))
 * Space complexity: O(1)
 * */
public class SearchSorted2DMatrix {
	
	// This is first solution where we call one function to get the row index where target value can be present
	// Then we call another function to do binary search over that row to look for the target value
    public boolean searchMatrix1(int[][] matrix, int target) {
    	
    	int rowIdx = searchPotentialRow(matrix, target);
    	
    	if(rowIdx == -1)
    	{
    		return false;
    	}
    	else
    	{
    		return binarySearchOverRow(matrix, rowIdx, target);
    	}
        
    }
    
    // Since this matrix is sorted, we do binary search of the first column to check which row start and end value can have target value
    private int searchPotentialRow(int[][] matrix, int target)
    {
    	int left = 0;
    	int right = matrix.length - 1;
    	
    	while(left <= right)
    	{
    		int mid = left + (right - left)/2;
    		
    		if(matrix[mid][0] <= target && matrix[mid][matrix[mid].length-1] >= target)
    		{
    			return mid;
    		}
    		else if(matrix[mid][0] < target)
    		{
    			left = mid + 1;
    		}
    		else if(matrix[mid][0] > target)
    		{
    			right = mid - 1;
    		}
    	}
    	return -1;
    }
    
    // In this function we do binary search over a particular row to check for the target
    private boolean binarySearchOverRow(int[][] matrix, int rowIdx, int target)
    {
    	int left = 0;
    	int right = matrix[rowIdx].length - 1;
    	
    	while(left <= right)
    	{
    		int mid = left + (right - left)/2;
    		
    		if(matrix[rowIdx][mid] == target)
    		{
    			return true;
    		}
    		else if(matrix[rowIdx][mid] < target)
			{
    			left = mid + 1;
			}
    		else
    		{
    			right = mid - 1;
    		}
    	}
    	
    	return false;
    }
    
    
    // This is another solution with slight change in the logic to find the required row index to be searched for
    // Here instead of doing binary search of first column, to get the required index, we just loop through each row and check its start and end value
    // Once such row is found, we call the same binary search over row function to look for target
    public boolean searchMatrix2(int[][] matrix, int target) {
    	
    	for(int i=0; i<matrix.length; i++)
    	{
    		if(matrix[i][0] <= target && matrix[i][matrix[i].length-1] >= target)
    		{
    			return binarySearchOverRow(matrix, i, target);
    		}
    	}
    	
    	return false;
        
    }
    
    
    public static void main(String[] args) {
		
    	int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
    	int target = 21;
    	
    	SearchSorted2DMatrix searchSorted2DMatrix = new SearchSorted2DMatrix();
    	System.out.println("Value present: "+searchSorted2DMatrix.searchMatrix2(matrix, target));
	}

}
