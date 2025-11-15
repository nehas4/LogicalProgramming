package LeetCodePractice.Arrays;

/*
 * [LeetCode 268]
 * 
 * Given an array nums containing n distinct numbers in the range [0, n], 
 * return the only number in the range that is missing from the array.
 * 
 * This problem can be solved using different solutions.
 * 
 * Time Complexity:
 * Space Complexity: 
 * */
public class MissingNumber {
	
	
	// In this solution we have calculated the sum of the range of numbers for n using formula: SUM(0...n) = (n * (n + 1))/2
	// Once that total is calculated then loop through each element in the array and subtract in from the SUM,
	// at the end we are left we are left with missing number in that sequence
	public int missingNumber1(int[] nums) {

        int len=nums.length;
        int total=(len * (len+1))/2;

        for(int num : nums)
        {
            total=total-num;
        }
        return total;
    }
	
	
	// In this solution we are calculating the XOR of all the numbers in the range of 0 to n
	// Then we are looping through each element in array and XOR that element with total XOR
	// Because of properties of XOR, we left with missing number at the end.
	// XOR properties:-
	// - Commutative: A XOR B = B XOR A
	// - A XOR B XOR C = C XOR B XOR A
	// - A XOR 0 = A
	// - A XOR A = 0
	public int missingNumber2(int[] nums) {

        int allXOR = 0;
        // Getting the XOR of all the numbers in the required range
        for(int i=0; i<=nums.length; i++)
        {
            allXOR = allXOR ^ i;
        }

        // Doing XOR of each existing number with all-range XOR so that at the end only missing number is left
        for(int num : nums)
        {
            allXOR = allXOR ^ num;
        }
        return allXOR; 

    }
	
	public static void main(String[] args) {
		
		int[] nums = {3,0,1};
		
		MissingNumber missingNumber = new MissingNumber();
		System.out.println(missingNumber.missingNumber2(nums));
	}

}
