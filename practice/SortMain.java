package practice;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SortMain {
    public static void main(String[] args) {
            SecureRandom secureRandom = new SecureRandom();
            
            int arraySize = 10000;
            int[] unsortedArray = new int[arraySize];
            Set<Integer> intSet = new HashSet<Integer>();
            
            for(int i = 0; i < unsortedArray.length; i++) {
                    int randomInt = secureRandom.nextInt(arraySize*2) + 1;
                    while(intSet.contains(randomInt)) {
                            randomInt = secureRandom.nextInt(arraySize*2) + 1;
                    }
                    intSet.add(randomInt);
                    unsortedArray[i] = randomInt;
            }
            
            System.out.println("size: " + arraySize);
            
            int[] sortedArray = unsortedArray.clone();
            Arrays.sort(sortedArray);
            
            System.out.println("unsorted array: " + Arrays.toString(unsortedArray));
            
            checkArraySorter(new SelectionSort(), unsortedArray.clone(), sortedArray);
            checkArraySorter(new InsertionSort(), unsortedArray.clone(), sortedArray);
            checkArraySorter(new QuickSort(), unsortedArray.clone(), sortedArray);
    }
    
    private static void checkArraySorter(ArraySorter arraySorter, int[] unsortedArray, int[] sortedArray) {
            System.out.print("performing "+arraySorter.getClass().getName()+"...");
            double startNanoTime = System.nanoTime();
            arraySorter.sort(unsortedArray);
            double endNanoTime = System.nanoTime();
            if(Arrays.equals(sortedArray, unsortedArray)) {
                    System.out.println("[OK] - " +  (int)((endNanoTime - startNanoTime)/1000000) + " milliseconds ");
            } else {
                    System.out.println("[XX] - " + Arrays.toString(unsortedArray));
            }
    }
}