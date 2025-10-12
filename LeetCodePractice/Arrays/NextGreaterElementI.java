package LeetCodePractice.Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {

	
	
/*
 * [LeetCode 496]
 * Given an array of integers that can be in any order, 
 * you need to return the index of the next greater element to the right of every element. 
 * Using a stack comes in very handy whenever you see a nested loop, 
 * or you need to iterate from the backward direction again and again.
 * 
 * Arguments: int[] nums1 - array-1 in which we need to check each element 
 * 				and see if there is a greater number after each element in array-2
 * 			int[] nnums2 - array-2 in which there are mix of various elements 
 * 			and we need to check this array for given set of elements in array-1 
 * 			and look for a greater number on the right of this array
 * 
 * Time complexity: O(N)
 * Space Complexity: O(N)
 * */
public int[] nextGreaterElement(int[] nums1, int[] nums2)
	{
		// Return empty result array if any of the given arrays are empty
		if(nums1.length == 0 || nums2.length == 0)
		{
			return new int[0];
		}
		
		// Create a result array of size of nums1 (array-1) whose elements need to be checked for next greater element in array-2 
		int[] result = new int[nums1.length];
		
		// Maintain a map, in which key will be the current element and value will be its related next greater element
		Map<Integer, Integer> nextGrtNumMap = new HashMap<Integer, Integer>();
		// Maintain a stack that will contain current/last greater element and whose value will be compared with current element
		Stack<Integer> currGrtNumStk = new Stack<>();
		
		// Will are going in the nums1 array backwards, to store next greater element for each num from back
		// Store in map last element as key and -1 as value, as there is no greater element after last element
		// Add last element in the stack
		nextGrtNumMap.put(nums2[nums2.length-1], -1);
		currGrtNumStk.add(nums2[nums2.length-1]);
		
		// Loop through second last element in nums2, till start element
		for(int i=nums2.length-2; i>=0; i--)
		{
			// Check if current top value in stack is greater than current nums2 value
			// Then add in map the current element and stack top value
			// And push the current element in stack
			if(nums2[i] < currGrtNumStk.peek())
			{
				nextGrtNumMap.put(nums2[i], currGrtNumStk.peek());
				currGrtNumStk.push(nums2[i]);
				continue;
			}
			
			// Remove element from stack until current element of nums2 is greater than stack top value
			while(!currGrtNumStk.isEmpty() && nums2[i] > currGrtNumStk.peek())
			{
				currGrtNumStk.pop();
			}
			
			// If Stack is empty, insert -1 in map for current element as there is no next greater element found\
			// And add current element in stack
			// Else put the stack top value in map and add in stack current element
			if(currGrtNumStk.isEmpty())
			{
				nextGrtNumMap.put(nums2[i], -1);
				currGrtNumStk.add(nums2[i]);
			}
			else
			{
				nextGrtNumMap.put(nums2[i], currGrtNumStk.peek());
				currGrtNumStk.push(nums2[i]);
			}
		}
		
		// Once the map is ready, loop through num1 array 
		// and check each element value in map for it related greater next number in nums2 and fill in result array
		for(int i=0; i < nums1.length; i++)
		{
			result[i] = nextGrtNumMap.get(nums1[i]);
		}
		
        return result;
    }


	public static void main(String[] args) {
		
		int[] nums1 = {4,1,2};
		int[] nums2 = {1,3,4,2};
		
		NextGreaterElementI nextGreaterElementI = new NextGreaterElementI();
		int[] result = nextGreaterElementI.nextGreaterElement(nums1, nums2);
		for(int i=0; i<result.length; i++)
		{
			System.out.print(result[i]+ " ");
		}
	}

}
