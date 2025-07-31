package LeetCodePractice.Arrays;

/*
 * Given an array, we need to find the number of good pairs that can be formed with the elements. A pair is said to be good if the elements are same and the left index is smaller than the right index.
 * */
public class NumberOfGoodPairs {
	
	// In this solution we maintaining a frequency array of 101 size as its mentioned in problem that value of nums can be max 100
	// Loop through nums array and increment the frequency of each value
    public int numIdenticalPairs(int[] nums) {
    	
    	int[] freq = new int[101];
    	
    	for(int i : nums)
    	{
    		freq[i]++;
    	}
    	
    	// Loop through each frequency and calculate nC2 to get number of pairs (2) for each frequency (n), then add up to total count
    	// Formula of nCr = n!/(n-r)!
    	// So evaluated formula of nC2 = n * (n-(n-1)) * (n-(n-2)) * (n-(n-3)) ..... * (n-(n-n)) / (n-2)!
    	// = (1 * 2 * 3 .... * (n-2) * (n-1) * n) / (n-2) * (n-3) .... * (n-n-2) * (n-n-1)
    	// = n * (n-1)/2 <-- what we are using to get the number of pairs that can be formed by a given number of frequency
    	int totalCnt = 0;
    	for(int i : freq)
    	{
    		totalCnt += (i * (i-1))/2;
    	}
        return totalCnt;
    }
    
    
    // This is another simpler solution where we loop through the nums and update total count while updating frequency as well
    public int numIdenticalPairs1(int[] nums) {
    	
    	int[] freq = new int[101];
    	int totalCnt = 0;
    	
    	for(int i : nums)
    	{
    		totalCnt += freq[i]++;
    	}
        return totalCnt;
    }
    
    public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,1,1,3};
		
		NumberOfGoodPairs numberOfGoodPairs = new NumberOfGoodPairs();
		System.out.println("Total number of good pairs are "+numberOfGoodPairs.numIdenticalPairs1(nums));
	}

}
