package LeetCodePractice.Arrays;

import java.util.Arrays;
import java.util.Scanner;
public class NumberPairsForTargetVal {
  
  // Function to do binary search of a given number on an array
  private boolean binarySearch(int[] arr, int numToFind)
  {
    int left = 0;
    int right = arr.length - 1;
    
    while(left <= right)
    {
      int mid = left + (left + right)/2;
      if(arr[mid] == numToFind)
      {
        return true;
      }
      if(arr[mid] < numToFind)
      {
        left = mid+1;
      }
      else
      {
        right = mid - 1;
      }
    }
    return false;
  }
  
  // This function finds the number of such pair values in array which has difference equal to target value
  // For each number in array we search for such number that can give targetValue after subtraction
  // We are using binary search for that, hence sorting the array in the start
  public int getTargetValPairs(int [] arr, int targetVal)
  {
    Arrays.sort(arr);
    
    int result = 0;
    
    for(int i : arr)
    {
      int valueToFind = i - targetVal;
      boolean isPair = binarySearch(arr, valueToFind);
      if (isPair)
      {
        result++;
      }
    }
    
    return result;
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
    
    System.out.println("Enter the target value: ");
    int targetVal = sc.nextInt();
    
    NumberPairsForTargetVal pairObj = new NumberPairsForTargetVal();
    System.out.println("Total number of pairs found are: "+pairObj.getTargetValPairs(inputArr, targetVal));
  }
}
