package practice;

public class SelectionSort implements ArraySorter
{
	@Override
	public void sort(int[] array)
	{
		// check for empty or null array
        if (array ==null || array.length==0){
            return;
        }
		int n = array.length;
		 
        // loop through the unsorted sub-array
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min = i;
            for (int j = i+1; j < n; j++)
                if (array[j] < array[min])
                    min = j;
 
            // Swap the found minimum element with the first element
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
	}
}
