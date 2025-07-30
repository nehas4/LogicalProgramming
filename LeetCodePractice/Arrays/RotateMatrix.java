package LeetCodePractice.Arrays;


/*
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * 
 * */
public class RotateMatrix {
	
	public void rotate(int[][] matrix)
	{
		int n = matrix.length;
		
		// Loop through each row till middle layer
		for(int i=0; i<(n+1)/2; i++)
		{
			// Loop through each column till middle
			for(int j=0; j<n/2; j++)
			{
				// Start 4-way swap
				// temp = bottom-left
				int temp = matrix[n-1-j][i];
				// bottom-left = bottom-right
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				// bottom-right = upper-right
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				// upper-right = upper-left
				matrix[j][n-1-i] = matrix[i][j];
				// upper-left = temp (bottom-left)
				matrix[i][j] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
		
		RotateMatrix rotateMatrix = new RotateMatrix();
		rotateMatrix.rotate(matrix);
		System.out.println("After rotating matrix 90 degrees below is the result:");
		for(int i=0; i<matrix.length; i++)
		{
			for(int j=0; j<matrix.length; j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

}
