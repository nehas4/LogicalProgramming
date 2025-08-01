package LeetCodePractice.Arrays;

/*
 * Given a staircase with n steps, we need to find the total number of distinct ways to climb it by taking 1 or 2 steps at a time.
 * */
public class ClimbingStairs {
	
	// In this solution we are using dynamic programming, where we take advantage of the fact that possible ways to reach n stairs is addition of (possible ways to climb n-1 stairs) and (possible ways to climb n-2 stairs)
	// Since we know that way to climb stair 1 is 1 and stair 2 is 2, so we move forward and loop till given n by adding up these values and getting new value of possible ways for n-1 and n-2  each time
    public int climbStairs(int n) {
    	
    	int noOfStepsForStair1 = 1;
    	int noOfStepsForStair2 = 2;
    	int possibleSteps = 0;
        
    	if(n == 1 || n == 2)
    	{
    		return n;
    	}
    	for(int i=3; i<=n; i++)
    	{
    		possibleSteps = noOfStepsForStair1 + noOfStepsForStair2;
    		noOfStepsForStair1 = noOfStepsForStair2;
    		noOfStepsForStair2 = possibleSteps;
    	}
    	
    	return possibleSteps;
    }

    public static void main(String[] args) {
    	
		ClimbingStairs climbingStairs = new ClimbingStairs();
		System.out.println("No of ways to climb 4 stairs (provided one can take 1 step or 2 step at a time) is "+climbingStairs.climbStairs(7));
	}
}
