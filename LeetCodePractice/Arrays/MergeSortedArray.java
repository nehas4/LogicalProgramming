class MergeSortedArray {
  
    // This function merges to sorted array in one array.
    // Array-1 has length of that can accomodate both the arrays values.
    // So we need to merge both the arrays in sorted way and save in array-1.
    // Starting from end, compare values of both array and whichever is maximum save it first in array-1, then decrement its pointer.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = n+m-1;
        int p1 = m-1;
        int p2 = n-1;

        while (p1 >= 0 && p2 >= 0)
        {
            if (nums1[p1] > nums2[p2])
            {
                nums1[p] = nums1[p1];
                p1--;
                p--;
            }
            else
            {
                nums1[p] = nums2[p2];
                p2--;
                p--;
            }
        }

        while(p2 >= 0)
        {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
        
    }
}
