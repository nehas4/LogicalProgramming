package LeetCodePractice.Arrays;

import java.util.Stack;
import java.util.Scanner;
public class EqualStacks {
  
  // Provided 3 arrays with different value as in cylinder height. Need to remove some cylinders from one or more cylinder of array so that each array total cyclinder height is same
  // For this we take 3 stacks and fill each  of the stacks with current sum at each index in array
  // Loop till none of the stack is empty
  // Get current hieght of each stack
  // Check which stack hieght is more than others and remove cylinder from it
  // Check if all 3 stack hieghts are same then return the hieght
  // Time Complexity = O(N1 + N2 + N3)
  // Space Complexity = O(N1 + N2 + N3)
  public int equalStacks(int[] h1, int[] h2, int[] h3)
  {
    Stack<Integer> stk1 = new Stack<>();
    Stack<Integer> stk2 = new Stack<>();
    Stack<Integer> stk3 = new Stack<>();
    
    // Fill the stacks with hieght sum at each index
    fillStacks(stk1, h1, stk2, h2, stk3, h3);
    
    int maxHieght = 0;
    while(!stk1.isEmpty() && !stk2.isEmpty() && !stk3.isEmpty())
    {
      // Get current height of each stack
      int stk1Hieght = stk1.peek();
      int stk2Hieght = stk2.peek();
      int stk3Hieght = stk3.peek();
      
      // Check if all height same then return the height
      if (stk1Hieght == stk2Hieght && stk2Hieght == stk3Hieght)
      {
        maxHieght = stk1.peek();
      }
      
      // Check is stack-1 height is more than others then remove cylinder from it
      if(stk1Hieght >= stk2Hieght && stk1Hieght >= stk3Hieght)
      {
        stk1.pop();
      }
      
      
      // Check is stack-2 height is more than others then remove cylinder from it
      if(stk2Hieght >= stk1Hieght && stk2Hieght >= stk3Hieght)
      {
        stk2.pop();
      }
      
      
      // Check is stack-3 height is more than others then remove cylinder from it
      if(stk3Hieght >= stk1Hieght && stk3Hieght >= stk2Hieght)
      {
        stk3.pop();
      }
    }
    return maxHieght;
  }
  
  // Function to fill the stacks with sum of hieghts at each hieght value
  private void fillStacks(Stack stk1, int[] h1, Stack skt2, int[] h2, Stack stk3, int[] h3)
  {
    int totalHieght = 0;
    for(int i=h1.length-1; i>=0; i--)
    {
      totalHieght += h1[i];
      stk1.push(totalHieght);
    }
    
    totalHieght = 0;
    for(int i=h2.length-1; i>=0; i--)
    {
      totalHieght += h2[i];
      skt2.push(totalHieght);
    }
    
    totalHieght = 0;
    for(int i=h3.length-1; i>=0; i--)
    {
      totalHieght += h3[i];
      stk3.push(totalHieght);
    }
  }

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Enter size of array-1: ");
    int size = sc.nextInt();
    int[] h1 = new int[size];
    System.out.println("Enter values of array-1: ");
    for (int i = 0; i < size; i++) {
      h1[i] = sc.nextInt();
    }
    
    System.out.println("Enter size of array-2: ");
    size = sc.nextInt();
    int[] h2 = new int[size];
    System.out.println("Enter values of array-2: ");
    for (int i = 0; i < size; i++) {
      h2[i] = sc.nextInt();
    }
    
    System.out.println("Enter size of array-3: ");
    size = sc.nextInt();
    int[] h3 = new int[size];
    System.out.println("Enter values of array-3: ");
    for (int i = 0; i < size; i++) {
      h3[i] = sc.nextInt();
    }
    
    EqualStacks es = new EqualStacks();
    int result = es.equalStacks(h1, h2, h3);
    System.out.println("Maximum Hiegth of the given 3 stacks if made equal after removing cylinder values is "+result);
  }
}
