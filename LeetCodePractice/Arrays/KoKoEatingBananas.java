package LeetCodePractice.Arrays;


/*
 * [LeetCode 875]
 * 
 * Given an array where each elements represents a pile of bananas:
 * 		- Koko wants to eat all in 'h' hours.
 * 		- Koko can set a speed to eat 'k' bananas per hour.
 * 		- Koko cannot change a pile during any hour.
 * Find the minimum speed possible.
 * 
 * Time Complexity: O(NlogN)
 * Space Complexity: O(1)
 * 
 * */
public class KoKoEatingBananas {

	/*
	 * In this solution we are using binary search technique.
	 * Possible ways to eat bananas range from 1 to maximum number of banana piles present in the array
	 * So maintain minSpeed as 1 and maxSpeed as maximum piles
	 * Loop through that range, and get the mid value. 
	 * Then call another helper function to check the hours required to each all piles with speed of 'mid' bananas per hour
	 * If it can can eat in time, then return true, else false.
	 * If returned true then update maxSpped as mid, else update minSpeed as mid+1
	 * At the end of the loop we will be reaching at the point where minSpeed (left pointer) will be required speed
	 * 
	 * */
    public int minEatingSpeed(int[] piles, int h) {
    	
    	int minSpeed = 1; // Minimum speed per hour with which bananas can be eaten
    	
    	// Loop through piles and get the max pile and set the maxSpeed
    	int maxSpeed = 0;
    	for(int pile : piles)
    	{
    		maxSpeed = Math.max(maxSpeed, pile);
    	}
    	
    	// Loop through all possible speeds with left and right pointer 
        while(minSpeed < maxSpeed)
        {
        	// Get the mid speed
        	int mid = minSpeed + (maxSpeed - minSpeed)/2;
        	
        	// Call the helper function canEatInTime to see if with given mid speed, eating in given h hours is possible
        	if(canEatInTime(piles, h, mid))
        	{
        		maxSpeed = mid; // Update maxSpeed if with given mid speed eating is possible in h hours
        	}
        	else
        	{
        		minSpeed = mid + 1; // Update minSpeed if with given mid speed, eating is not possible in h hours
        	}
        }
        
        return minSpeed; // Returned minSpeed that will give us the minimum speed with which eating in h hours is possible
    }
    
    // Function to return true or false based on whether with given speed all the piles can be eaten in time
    private boolean canEatInTime(int[] piles, int h, int speed)
    {
    	int hours = 0;
    	// Loop through each pile and divide it with speed to get total hours required to each pile
    	for(int pile : piles)
    	{
    		hours += Math.ceil((double) pile/speed);
    	}
    	
    	// Return true if calculated hours is less than given hour limit
    	return hours <= h;
    }
    
    public static void main(String[] args) {
		
    	int[] piles = {3,6,7,11};
    	int h = 8;
    	
    	KoKoEatingBananas koEatingBananas = new KoKoEatingBananas();
    	System.out.println(koEatingBananas.minEatingSpeed(piles, h));
	}
}
