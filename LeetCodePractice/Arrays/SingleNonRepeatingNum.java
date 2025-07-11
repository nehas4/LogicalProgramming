import java.util.Scanner;

// This class has function to return single non-repeating number in a array
// This problem can be solved by maintaining a map ti save the number and its related frequency
// Here it is solved by using xor bitwise operator. This operator is commutative.
// A xor A = 0
// A xor 0 = A
// A xor B xor C = A xor C xor B
public class SingleNonRepeatingNum {

  int singleNumber(int[] numArr) {
    int result = numArr[0];
    for (int i = 1; i < numArr.length; i++) {
      result = result ^ numArr[i];
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

    SingleNonRepeatingNum srn = new SingleNonRepeatingNum();
    System.out.println(
      "Single non-repeating number in given array is: " +
      srn.singleNumber(inputArr)
    );
  }
}
