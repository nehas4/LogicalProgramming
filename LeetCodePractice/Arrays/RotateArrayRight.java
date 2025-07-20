class RotateArrayRight {

    // Function to rotate an array for k times
    public void rotate(int[] nums, int k) {
        k%=nums.length;

        // Reverse full array first
        reverse(nums, 0, nums.length-1);

        // Reverse first k elements now
        reverse(nums, 0, k-1);

        // Reverse rest of the elements leaving first k elements
        reverse(nums, k, nums.length-1);
    }

    // Helper function to reverse elements of array from the given start to end index
    private void reverse(int[] arr, int start, int end)
    {
        while(start < end)
        {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }
}
