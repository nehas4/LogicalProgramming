import java.util.Scanner;
public class MaxSubArray {
  
  // This function returns the maximum sum of contiguous subarray in a given array of numbers
  // Here we are using approach called memorization, means we are using already derived result to solve further problem
  // This is an example of dynamic problem
  // This approach also called KADANE's algorithm
  // Time Complexity = O(N)
  // Space Complexity = O(1)
  public int maxSubArray(int[] array)
  {
    int max = array[0];
    int curr_max = array[0];
    for(int i=1; i<array.length; i++)
    {
      curr_max = Math.max(array[i], array[i]+curr_max);
      
      max = Math.max(max, curr_max);
    }
    return max;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter size of array: ");
    int size = sc.nextInt();
    int[] inputArr = new int[size];
    System.out.println("Enter values of array: ");
    for (int i = 0; i < size; i++) {
      inputArr[i] = sc.nextInt();
    }
    
    MaxSubArray msa = new MaxSubArray();
    System.out.println("Maximim sum of contiguous subarray for given array is "+msa.maxSubArray(inputArr));
  }
}
