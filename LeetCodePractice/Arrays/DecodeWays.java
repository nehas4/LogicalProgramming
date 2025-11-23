package LeetCodePractice.Arrays;


/*
 * [LeetCode 91]
 * 
 * Given a string of integers, find the total number of ways it can be decoded.
 * This problem is also an example of Dynamic Programming with Memoization.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * 
 * */
public class DecodeWays {
	
	/*
	 * Maintain a temp array that will store the no of ways to decode till each length/index
	 * At each index we see if we check if previous numbers and previous 2 numbers are valid character,
	 * then increment the current count at current index/length in temo array
	 * */
	int numDecodings(String s) {
		int n = s.length();
	    // Create a temp array to store the count of possible ways to decode at each length in string
	    int[] dp = new int[n + 1];
	    dp[0] = 1; // Initialize 1 at 0th length, as no of possible ways to decode at 0 is one only
	    dp[1] = s.charAt(0) == '0' ? 0 : 1; // If there is only one number only then it can be decoded as in 1 way only as one character

	    // Loop from 2nd index in the string
	    for (int i = 2; i <= n; i++) {
	    	
	    	int oneDigit = Integer.valueOf(s.substring(i - 1, i)); //Get last number to check
	    	int twoDigits = Integer.valueOf(s.substring(i - 2, i)); //Get last 2 numbers to check
		
	    	// Check if last number is greater than 0, means in the range 1-9, 
	    	// then its one way to decode so increment the current index of temp array with last index count
	    	if (oneDigit >= 1)
	    		dp[i] += dp[i - 1];
		
	    	// Check if last  number is greater than 9 and less than 27, means in the range 10-26, 
	    	// then its second way to decode so increment the current index of temp array with second last index count
	    	if (twoDigits >= 10 && twoDigits <= 26)
	    		dp[i] += dp[i - 2];
	    }

	    return dp[n];
	}
	
	public static void main(String[] args) {
		
		String s = "226";
		
		DecodeWays decodeWays = new DecodeWays();
		System.out.println(decodeWays.numDecodings(s));
	}

}
