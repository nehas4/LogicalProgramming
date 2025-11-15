package LeetCodePractice.Arrays;


/*
 * [LeetCode 169]
 * 
 * Given an array nums of size n, return the majority element.\
 * The majority element is the element that appears more than ⌊n / 2⌋ times. 
 * You may assume that the majority element always exists in the array.\
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */
class MajorityElement {
    // This function finds the majority element, means number with maximum occurrences in an array.
    // This can be solved by different methods.
    // 1. By maintaining map with each number frequency. But it has space complexity as O(N) as it uses HashMap.
    // 2. By sorting the array and then taking the middle value, which will be the majority value. But this has time complexity as NlogN as it uses sorting.
    // 3. Below solution which has time complexity as O(N) and space complexity O(1).
    // In this solution we loop through each element in array and decides one majority number and its current votes
    // If current element is equal to majority number then increment votes else decrement it.
    // If any time votes go 0, change the majority number, and follow same steps. This leaves us with real majority number in the end.
    public int majorityElement(int[] nums) {

        int majority = nums[0];
        int votes = 1;
        
        for (int i=1; i<nums.length; i++)
        {
            if (votes == 0)
            {
                majority = nums[i];
                votes++;
            }
            else if (majority == nums[i])
            {
                votes++;
            }
            else
            {
                votes--;
            }
        }
        return majority;
    }
    
    public static void main(String[] args) {
		int[] inputArr = new int[] {1,1,3,2,3,3};
		MajorityElement me = new MajorityElement();
		System.out.println("Majority of given element is "+me.majorityElement(inputArr));
	}
}
