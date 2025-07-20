class RemoveDuplicates2 {
    // This function removes duplicates in a sorted array such that maximum 2 instances of an element can be present and not more than that.
    // For that compare each element with index-2 value and if not same then only save in array and move forward.
    public int removeDuplicates(int[] nums) {
        if ( nums.length < 3)
        {
            return nums.length;
        }

        int validIndex = 2;
        for (int i=2; i < nums.length; i++)
        {
            if (nums[i] != nums[validIndex-2])
            {
                nums[validIndex] = nums[i];
                validIndex++;
            }
        }
        return validIndex;
    }
}
