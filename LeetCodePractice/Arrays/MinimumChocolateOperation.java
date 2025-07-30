package LeetCodePractice.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinimumChocolateOperation {
	
	public int equal(List<Integer> arr)
	{
		// Store all possibilities. Since we can distribute/take 1 or 2 or 5 chocolates only. So total possibilities can be ranging from min to min-4, means total 5 in count
		int[] possibilities = new int[5];
		
		// Start with minimum element
		int minimum =  arr.stream().min(Comparator.naturalOrder()).get();
		
		// Loop through all possibilities
		for(int i=0; i<possibilities.length; i++)
		{
			// Loop through chocolates array for every minimum value, to get the steps required to reach that value for each element
			for(int k : arr)
			{
				// Get the difference of current number of chocolates and minimum value to reach
				int diff = k - minimum;
				// Get the steps required to reach that difference value by - dividing it by 5 + (rest of the chocolates) divide by 2 + (rest of chocolates) divide by 1
				int stepsRequired = diff/5 + (diff % 5)/2 + ((diff % 5) % 2)/1;
				// Add the steps required in current possibilities
				possibilities[i] += stepsRequired;
			}
			// Decrement minimum value to check no of steps required to reach that value throughout array
			minimum--;
		}
		return Arrays.stream(possibilities).min().getAsInt();
	}
	
	
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(11);
		arr.add(6);
		arr.add(8);
		arr.add(7);
		MinimumChocolateOperation minimumChocolateOperation = new MinimumChocolateOperation();
		System.out.println("Minimum operations required to distribute equal number of chocolates is "+minimumChocolateOperation.equal(arr));
	}
}
