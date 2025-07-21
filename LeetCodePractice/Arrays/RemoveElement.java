package LeetCodePractice.Arrays;

class RemoveElement {
    // This function removes all occurence of a given value in an array, in-place without changing the order of elements
    // For this maintain one pointer for array where values need to be retained
    // Loop through array and for each element not equal to given value, save it at retaining pointer and increment the pointer
    // It doesn't matter what remains at the end indexes of array after removal of value and retaining the valid elements
    public int removeElement(int[] nums, int val) {
        int retain_element_cnt = 0;
        for(int i=0; i<nums.length; i++)
        {
            if (nums[i] != val)
            {
                nums[retain_element_cnt] = nums[i];
                retain_element_cnt++;
            }
        }
        return retain_element_cnt;
    }
}
