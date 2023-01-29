package practice;

public class InsertionSort implements ArraySorter
{
	@Override
	public void sort(int[] array)
	{
		// check for empty or null array
        if (array ==null || array.length==0){
            return;
        }
		int n = array.length;
		
        for (int i = 1; i < n; ++i)
        {
        	// Consider the current element of loop as key
            int key = array[i]; 
            int j = i - 1; 
  
            //Move elements of array, that are greater than key, to one position ahead of their current position
            while (j >= 0 && array[j] > key)
            { 
                array[j + 1] = array[j]; 
                j = j - 1; 
            } 
            array[j + 1] = key; 
        }
	}
}
