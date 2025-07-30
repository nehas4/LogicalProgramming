package LeetCodePractice.Arrays;

/*
 * You are given an array of integers, that have all unique values except one integer that may be duplicated more than 2 times. You just need to return this value.
 * */

// This problem can be solved various ways:
//		- By sorting the array and checking the adjacent values as duplicate
//		- By using hashset to store the elements and in case one element already found then its a duplicate
public class FindDuplicate {
	
	// This solution is time and space efficient solution to find duplicate
	// It uses the concept of detecting a loop in linked list
	public int findDuplicate(int[] nums)
	{
		// Initialize a start and fast pointer
		int slow = 0;
		int fast = 0;
		
		// Move both the pointers forward until they meet
		// where slow is moved one step forward ad fast is moved 2 step forward
		do
		{
			slow = nums[slow];
			fast = nums[nums[fast]];
					
		} while(slow != fast);
		
		
		// As soon as both the pointers meet, reset the slow pointer and move them at same speed until they meet again
		slow = 0;
		while(slow != fast)
		{
			slow = nums[slow];
			fast = nums[fast];
		}
		
		return slow;
	}
	
	public static void main(String[] args) {
		
		int[] nums = new int[] {2,6,4,1,3,1,5};
		FindDuplicate findDuplicate = new FindDuplicate();
		System.out.println("Duplciate found is "+findDuplicate.findDuplicate(nums));
	}

}
