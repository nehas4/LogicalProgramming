package practice;

public class QuickSort implements ArraySorter
{
	private int[] numbers;
	private int number;
    
	@Override
	public void sort(int[] array)
	{
		// check for empty or null array
        if (array ==null || array.length==0){
            return;
        }
        
        this.numbers = array;
        number = array.length;
        quicksort(0, number - 1);
	}
	
	private void quicksort(int low, int high)
	{
        int i = low, j = high;
        
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high-low)/2];

        // Divide into two lists
        while (i <= j)
        {
            // If the current value from the left list is smaller than the pivot element then get the next element from the left list
            while (numbers[i] < pivot)
            {
                i++;
            }
            
            // If the current value from the right list is larger than the pivot element then get the next element from the right list
            while (numbers[j] > pivot)
            {
                j--;
            }

            /* If we have found a value in the left list which is larger than the pivot element and if we have found a value in the right list 
             * which is smaller than the pivot element then we exchange the values. As we are done we can increase i and j
             */
            if (i <= j)
            {
                swap(i, j);
                i++;
                j--;
            }
        }
        
        // Now follow recursion to call quicksort method again with new low and high values
        if (low < j)
            quicksort(low, j);
        
        if (i < high)
            quicksort(i, high);
    }

	//Method to swap the given values
    private void swap(int i, int j)
    {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
