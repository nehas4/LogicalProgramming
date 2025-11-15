package LeetCodePractice.Arrays;

/*
 * [LeetCode 1267]
 * 
 * Given a map of a server center, represented as a m * n integer matrix grid, 
 * where 1 means that on that cell there is a server and 0 means that it is no server. 
 * Two servers are said to communicate if they are on the same row or on the same column.
 * Return the number of servers that communicate with any other server.
 * 
 * Time Complexity: O(n * m)
 * Space Complexity: O(n + m)
 * 
 * */
public class CountServersThatCommunicate {

	// We maintain 2 arrays representing the number of rows and columns respectively
	// Loop through matrix and if 1 found at any index, set that particular row and column array index as 1
	// Loop again in matrix and if any server found, check the related row and column value in the array.
	// If more than 1 servers found in that row or column then increment the connected server value.
    public int countServers(int[][] grid) {

        int rows = grid.length;
        int columns = rows == 0? 0 : grid[0].length;

        int[] serversInRows = new int[rows];
        int[] serversInCols = new int[columns];

        int servers = 0;

        for(int row=0; row < rows; row++)
        {
            for(int col=0; col < columns; col++)
            {
                if(grid[row][col] == 1)
                {
                    ++serversInRows[row];
                    ++serversInCols[col];
                }
            }
        }

        for(int row=0; row < rows; row++)
        {
            for(int col=0; col < columns; col++)
            {
                if(grid[row][col] == 1 && (serversInRows[row] > 1 || serversInCols[col] > 1))
                {
                    ++servers;
                }
            }
        }
        return servers;
    }
    
    public static void main(String[] args) {
		
    	int[][] matrix = {{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
    	
    	CountServersThatCommunicate countServersThatCommunicate = new CountServersThatCommunicate();
    	System.out.println("Total connected servers are: "+countServersThatCommunicate.countServers(matrix));
    	
	}
}