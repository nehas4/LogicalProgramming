import java.util.Scanner;
public class RotateLeft1 {
  
  // Rotate all the numbers towards left for given k number times
  // This is method one rotate left by maintaining a temp array to keep initial k numbers
  // Then shift rest of the number towards left skipping k positions
  public int[] rotateLeft(int[] arr, int k)
  {
    // If array length is same as k then result of rotation is same as original array, so if k is greater than array length, we need to rotate only k % arr.length times
    k %= arr.length;
    
    int[] tmp = new int[k];
    // save first k numbers in tmp array
    for(int i=0; i<k; i++)
    {
      tmp[i] = arr[i];
    }
    
    // shift rest of the number k position to left
    for(int i=k; i<arr.length; i++)
    {
      arr[i-k] = arr[i];
    }
    
    int j=0;
    // put tmp array data at the end
    for(int i=arr.length-k; i<arr.length; i++)
    {
      arr[i] = tmp[j];
      j++;
    }
    return arr;
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
    
    System.out.println("Enter the no of left rotation: ");
    int k = sc.nextInt();
    
    RotateLeft1 rl = new RotateLeft1();
    int[] result = rl.rotateLeft(inputArr, k);
    System.out.println("Rotated array is: ");
    for(int i=0; i<result.length; i++)
    {
      System.out.print(result[i]+" ");
    }
    
  }
}
