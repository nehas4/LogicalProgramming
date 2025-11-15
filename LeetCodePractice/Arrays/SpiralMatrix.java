package LeetCodePractice.Arrays;

import java.util.ArrayList;
import java.util.List;


/*
 * [LeetCode 54]
 * 
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * 
 * In order to do so maintain 4 pointers for start and end index of row and column respectively.
 * Traverse in spiral order with 4 loops to traverse in different directions and increment/decrement pointers as you move ahead.
 * 
 * Time Complexity: O(m * n)
 * Space Complexity: O(1)
 * 
 * */
public class SpiralMatrix {

	// Maintain 4 pointers for start and end rows and column
	// Use 4 loops to traverse in spiral order
	// - Left to right
	// - Top to bottom
	// - Right to Left
	// - Bottom to Top
    public List<Integer> spiralOrder(int[][] matrix) {

        int rowBegining = 0;
        int rowEnd = matrix.length - 1;
        int colBegining = 0;
        int colEnd = matrix[0].length - 1;

        List<Integer> result = new ArrayList<>();

        if(matrix.length == 0)
        {
            return result;
        }

        while(rowBegining <= rowEnd && colBegining <= colEnd)
        {
            // Traversing from left to right
            for(int i = colBegining; i <= colEnd; i++)
            {
                result.add(matrix[rowBegining][i]);
            }
            rowBegining++;

            // Traversing from top to bottom
            for(int i = rowBegining; i <= rowEnd; i++)
            {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            if(rowBegining <= rowEnd) // Condition to avoid out of index exception
            {
                // Traversing from right to left
                for(int i = colEnd; i >= colBegining; i--)
                {
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            if(colBegining <= colEnd) // Condition to avoid out of index exception
            {
                // Traversing from bottom to top
                for(int i = rowEnd; i >= rowBegining; i--)
                {
                    result.add(matrix[i][colBegining]);
                }
            }
            colBegining++;
        }

        return result;
    }
    
    
    public static void main(String[] args) {
		
    	int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    	
    	SpiralMatrix spiralMatrix = new SpiralMatrix();
    	List<Integer> result = spiralMatrix.spiralOrder(matrix);
    	for(int n : result)
    	{
    		System.out.print(n+" ");
    	}
    	
	}
    
}