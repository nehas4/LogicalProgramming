package LeetCodePractice.Arrays;

import java.util.LinkedList;
import java.util.Queue;


/*
 * [LeetCode 1306]
 * 
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array. 
 * When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.
 * NOTE: Notice that you can not jump outside of the array at any time.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * 
 * */
public class JumpGame3 {

	/*
	 * In this solution we maintain a queue where we maintain queue to store the elements that we need to visit in order level traversing.
	 * At each point we look for the steps to go forward and backward, then add it in queue as the next possible traversals
	 * We also check that the possible steps are not going less or more than the available indices.
	 * At any point if we reach at step having 0 as value, we return true, else false
	 * */
    public boolean canReach(int[] arr, int start) {
        
        Queue<Integer> q = new LinkedList<>(); // Queue to maintain possible steps indices from current point
        q.add(start); // Adding the starting point index in the queue to check for possible steps from this point

        // Loop until queue is empty i.e., no other possible steps left
        while(!q.isEmpty())
        {
            int curr_pos = q.poll(); // Get the first element from queue

            // If value at this point is 0, then return true
            if(arr[curr_pos] == 0)
            {
                return true;
            }

            // If current index is already checked (have negative value), then continue to next element to check in queue
            if(arr[curr_pos] < 0)
            {
                continue;
            }

            // If from  current position, we move forward with the given number of steps and its less than total steps,
            // then add the next step in the queue to check
            if(curr_pos + arr[curr_pos] < arr.length)
            {
                q.add(curr_pos + arr[curr_pos]);
            }
            // If from  current position, we move backward with the given number of steps and its greater than first step,
            // then add the next step in the queue to check
            if(curr_pos - arr[curr_pos] >= 0)
            {
                q.add(curr_pos - arr[curr_pos]);
            }

            // Any step that is already checked make it a negative number to indicate that its already checked
            arr[curr_pos] = -arr[curr_pos];
        }
        return false;
    }
    
    
    /*
     * This solution uses recursive call approach.
     * We are making 2 recursive calls: one to move forward and another to move backward with given steps value at current position
     * Then we evaluate the result of both and return true if for any call the answer is true
     * */
    public boolean canReach1(int[] arr, int start) {
    	
    	// Check is current position (start) is inside the boundaries and whether this position is already checked (is negative)
    	if(start < 0 || start >= arr.length || arr[start] < 0)
        {
            return false;
        }
    	
    	// If current step value is 0, then return true
        if(arr[start] == 0)
        {
            return true;
        }
        
        //Make the current step value as negative, to indicate that this step is already checked
        arr[start] = -arr[start];
        // Recursive call to check steps when we move forward
        boolean result1 = canReach(arr, start+arr[start]);
        // Recursive call to check steps when we move backwards
        boolean result2 = canReach(arr, start-arr[start]);
        
        // Returning true if any of the recursive calls gives true as result
        return result1 || result2;
    	
    }
    
    public static void main(String[] args) {
		
    	int[] arr = {4,2,3,0,3,1,2};
    	int start = 5;
    	
    	JumpGame3 jumpGame3 = new JumpGame3();
    	System.out.println("Can Jump: "+jumpGame3.canReach(arr, start));
	}
}