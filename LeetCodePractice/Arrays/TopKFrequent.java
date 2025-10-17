package LeetCodePractice.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * [LeetCode 347]
 * 
 * Given an integer array numbers and an integer k, return the k most frequent elements. 
 * You may return the answer in any order.
 * 
 * Solution provided uses the bucket sort algorithm.
 * 
 * Time complexity: 
 * Space complexity:
 * */
public class TopKFrequent {
	
	/*
	 * In this function we are using bucket method to store elements at a particular frequency
	 * First we get the frequency of each element into a map
	 * Then loop through map and at each frequency indexx in bucket, put that element value
	 * Later we loop through this backwards direction and get highest frequent elements
	 * 
	 * */
    public int[] topKFrequent(int[] nums, int k) {

    	// Bucket to store elements at each frequency index
        List<Integer>[] freqBucket = new List[nums.length+1];
        // Map to store element as key and its frequency as value
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Evaluate each elements frequency and store in map
        for(int num : nums)
        {
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        }

        // Loop through map to process each frequency and place it in bucket
        for(int key : freqMap.keySet())
        {
            int curr_freq = freqMap.get(key);
            if(freqBucket[curr_freq] == null)
            {
                freqBucket[curr_freq] = new ArrayList<>();
            }
            freqBucket[curr_freq].add(key);
        }
        
        int[] result = new int[k];
        int pos=0; // To maintain current index in result so that only k elements are written
        for(int i=freqBucket.length-1; i>=0 && pos<k; i--)
        {
            if(freqBucket[i] != null)
            {
                List<Integer> currTopNum = freqBucket[i];
                for(int num : currTopNum)
                {
                    result[pos++]=num;
                }
            }
        }

        return result;
    }
    
    
    public static void main(String[] args) {
		
    	int[] nums = {1,2,1,2,1,2,3,1,3,2};
    	int k = 2;
    	
    	TopKFrequent kFrequent = new TopKFrequent();
    	int[] result = kFrequent.topKFrequent(nums, k);
    	for(int i : result)
    	{
    		System.out.print(i+" ");
    	}
	}
}
