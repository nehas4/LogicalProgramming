package LeetCodePractice.Arrays;

import java.util.List;

/*
 * [LeetCode 73]
 * 
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's IN-PLACE.
 * 
 * Time Complexity: O(n * m)
 * Space complexity: O(1)
 * 
 * */
public class SetMatrixZeroes {

	// In this solution, we are checking each element, if its value is 0 then setting that row in first column as 0 and that column in first row as 0
	// Basically in order to determine if a particular column contains any, we are setting its value as 0 in first row
	// And to know if a particular row contains 0 setting that row in first column as 0
	// Later loop through this matrix again (leaving first row and column), for each element check if its related row is 0 or column is 0, then convert its value as 0
	// Also maintain 2 flag and set it as true if first row or column has 0
	// Later at the end if any of its value is set then make other values in first row and column as 0
    public void setZeroes(int[][] matrix) {
        
        int rowCnt = matrix.length;
        int colCnt = rowCnt == 0 ? 0 : matrix[0].length;
        boolean firstRowZero = false, firstColZero = false;

        for(int row=0; row<rowCnt; row++)
        {
            for(int col=0; col<colCnt; col++)
            {
                if(matrix[row][col] == 0)
                {
                    if(row == 0)
                        firstRowZero = true;
                    if(col == 0)
                        firstColZero = true;

                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for(int row=1; row<rowCnt; row++)
        {
            for(int col=1; col<colCnt; col++)
            {
                if(matrix[row][0] == 0 || matrix[0][col] == 0)
                {
                    matrix[row][col] = 0;
                }
            }
        }

        if(firstRowZero)
            for(int col=0; col<colCnt; col++)
                matrix[0][col] = 0;

        if(firstColZero)
            for(int row=0; row<rowCnt; row++)
                matrix[row][0] = 0;
    }
    
    public static void main(String[] args) {
		
    	int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
    	
    	System.out.println("Before setting zeros:---");
    	for(int row=0; row<matrix.length; row++)
        {
            for(int col=0; col<matrix[0].length; col++)
            {
            	System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
    	System.out.println();
    	
    	SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
    	setMatrixZeroes.setZeroes(matrix);
    	
    	System.out.println("After setting zeros:---");
    	for(int row=0; row<matrix.length; row++)
        {
            for(int col=0; col<matrix[0].length; col++)
            {
            	System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
    	
	}
}