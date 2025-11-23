package LeetCodePractice.Arrays;

import java.util.Arrays;


/*
 * [LeetCode 881]
 * 
 * Given an array of people weights, and a maximum weight limit. Find the maximum boats such that each boat has a maximum capacity of 2.
 * 
 * Time Complexity: 
 * Space Complexity: 
 * 
 * */
public class BoatsToSavePeople {

	/*
	 * In this solution we first sort the array so that lass weight people are at the front of array and maximum weight people are at the end of the array.
	 * Maintain 2 pointer one to the start of the array and one to the end of the array
	 * While looping check if current left (less weight person) and right (more weight person) can be put in same boat or not means if their weight together is less than limit
	 * Based on above condition increment left pointer if left person is included in boat.
	 * Decrement right pointer irrespective because that person will always be in boat.
	 * Also increment number of boats.
	 * */
    public int numRescueBoats(int[] people, int limit) {
        
        Arrays.sort(people); // Sort the array to have less weight people in front and more weight in the end of array
    	int boats = 0;
    	
    	int left = 0;
    	int right = people.length - 1;
    	
    	while(left <= right)
    	{
    		// Check if left (less weight) person weight and right (more weight) person weight is in the given limit
    		// then move the left point forward, indicating that we are picking both left and right pointer person in current boat
    		if(people[left] + people[right] <= limit)
    		{
    			left++;
    		}
    		
    		right--; // Decrement right pointer irrespective as that person will always be placed in boat
    		boats++; // Increment boats
    	}
    	
    	return boats;
    }
    
    public static void main(String[] args) {
		
    	int[] people = {3,2,2,1};
    	int limit = 3;
    	
    	BoatsToSavePeople boatsToSavePeople = new BoatsToSavePeople();
    	System.out.println(boatsToSavePeople.numRescueBoats(people, limit));
	}
}