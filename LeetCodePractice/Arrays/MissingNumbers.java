import java.util.TreeMap;
import java.util.Map;
import java.util.Scanner;
public class MissingNumbers {
  
  // This functions returns sorted list of missing numbers which are present in array-1:arr but not present in array-2: brr
  // Here we are using a treeMap to store the values of array-1 and its frequency.
  // For second array we decrement the frequency and remove any value which has 0 frequency
  // So we are left with only numbers/values which are not present in second array
  // Last we add all the vLues of treeMap to result array. Since treeMap store  alues in sorted order so we get list if sorted missing numbers
  public int[] missingNumbers(int[] arr, int[] brr)
  {
    TreeMap<Integer, Integer> intTreeMap = new TreeMap<>();
    
    for (int i : brr) {
      int freq = intTreeMap.getOrDefault(i,0);
      freq++;
      intTreeMap.put(i, freq);
    }
    
    for (int i : arr) {
      int freq = intTreeMap.getOrDefault(i,0);
      freq--;
      if(freq == 0)
      {
        intTreeMap.remove(i);
      }
      else
      {
        intTreeMap.put(i, freq);
      }
    }
    
    int [] result = new int[intTreeMap.size()];
    int i = 0;
    for(Map.Entry<Integer, Integer> integerEntry : intTreeMap.entrySet())
    {
      result[i++] = integerEntry.getKey();
    }
    return result;
  }

  public static void main(String[] args)                       
  {
    Scanner sc = new Scanner(System.in);
    
    // Get input of first array
    System.out.println("Enter size of array=1: ");
    int size = sc.nextInt();
    int[] arr = new int[size];
    System.out.println("Enter values of array-1: ");
    for (int i = 0; i < size; i++) {
      arr[i] = sc.nextInt();
    }
    
    // Get input of second array
    System.out.println("Enter size of array=2: ");
    size = sc.nextInt();
    int[] brr = new int[size];
    System.out.println("Enter values of array-2: ");
    for (int i = 0; i < size; i++) {
      brr[i] = sc.nextInt();
    }
    
    //Call missing numbers functions
    MissingNumbers mn = new MissingNumbers();
    int[] result = mn.missingNumbers(arr, brr);
    
    System.out.println("Below are the list of missing numbers in second array: ");
    for(int i : result)
    {
      System.out.print(i+" ");
    }
  }
}
