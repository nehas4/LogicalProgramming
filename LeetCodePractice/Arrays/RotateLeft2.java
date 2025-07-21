package LeetCodePractice.Arrays;

import java.util.Scanner;
public class RotateLeft2 {
  
  // Rotate all the numbers towards left for given k number times
  // Have a reverse function with start and end index of array/sub-arrat to reverse
  // First reverse the whole array
  // Second reverse array from start till length - k
  // Third reverse the last k mumber
  // Time Complexity = O(N)
  // Space Complexity = O(N)
  public int[] rotateLeft(int[] arr, int k)
  {
    // If array length is same as k then result of rotation is same as original array, so if k is greater than array length, we need to rotate only k % arr.length times
    k %= arr.length;
    // reverse whole array
    reverse(arr, 0, arr.length-1);
    
    // reverse first arr.length-k number
    reverse(arr, 0, arr.length-k-1);
    
    // reverse last k numbers
    reverse(arr, arr.length-k, arr.length-1);
    
    return arr;
  }
  
  public void reverse(int[] arr, int start, int end)
  {
    while (start < end) {
      int tmp = arr[start];
      arr[start] = arr[end];
      arr[end] = tmp;
      start++;
      end--;
    }
  }

  public static void main(String[] args) 
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter size of array: ");
    int size = sc.nextInt();
    int[] inputArr = new int[size];
    System.out.println("Enter values of array: ");
    for (int i = 0; i < size; i++) {
      inputArr[i] = sc.nextInt();
    }
    
    System.out.println("Enter the no of left rotation: ");
    int k = sc.nextInt();
    
    RotateLeft2 rl = new RotateLeft2();
    int[] result = rl.rotateLeft(inputArr, k);
    System.out.println("Rotated array is: ");
    for(int i=0; i<result.length; i++)
    {
      System.out.print(result[i]+" ");
    }
  }
}
