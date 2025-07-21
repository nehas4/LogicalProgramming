package LeetCodePractice.Arrays;

class RemoveDuplicates1 {
    // This function removes the duplicates in a sorted array, keeping only single instances of each element
    // All the unique elements should be at the start of array and doesnt matter whats left at the end
    // Maintain, index to save unique values
    // Loop through array and check if current value is not same as previous value in array then save that value at unique index, also increment that index.
    public int removeDuplicates(int[] nums) {
        int uniqValIndex = 1;
        for(int i=1; i < nums.length; i++)
        {
            if (nums[i] != nums[i-1])
            {
                nums[uniqValIndex] = nums[i];
                uniqValIndex++;
            }
        }
        return uniqValIndex;
    }
}
