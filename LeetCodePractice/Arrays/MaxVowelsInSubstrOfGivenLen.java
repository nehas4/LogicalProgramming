package LeetCodePractice.Arrays;

import java.util.HashSet;
import java.util.Set;


/*
 * [LeetCode 1456]
 * 
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 * This is an example of sliding window problem
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * 
 * */
public class MaxVowelsInSubstrOfGivenLen {

	/* Since we need to check the vowels in every substring of length k in given string, we can use sliding window technology.
	 * First store the vowels characters to check in a set.
	 * Maintain 2 variables: maxVowels - to store the maximum number of vowels currently, windowsVowels - number of vowels in current window.
	 * Get the total vowels in the first window of k elements and initialize the max vowels and windows vowels count.
	 * Then loop through the string starting from Kth element, for each new character in new window, update windows vowels count and max vowels count.
	**/
    public int maxVowels(String s, int k) {
        
        int maxVowels = 0; // To store the max vowels evaluated in substring of Kth length
        int windowsVowels = 0; // To store number of vowels in current K elements windows

        // Set to store all the vowels characters to check
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        // Loop through first Kth elements, check for each character as vowels and update current window's vowels
        for(int i=0; i<k; i++)
        {
            if(vowels.contains(s.charAt(i)))
            {
                windowsVowels++;
            }
        }
        maxVowels = windowsVowels; // Initialize the max vowels with first windows vowels number

        // Staring from Kth element loop through each character till the end in the given string, to check each possible Kth length substring for vowels
        for(int i=k; i<s.length(); i++)
        {
        	
        	// Since we are sliding through the array, leaving one character before current window and adding new character
        	// If the last character in last window is vowel, the decrement the windows vowels count as its not part of current window, else do nothing
            if(vowels.contains(s.charAt(i - k)))
            {
                windowsVowels--;
            }

            // If new added character in the current window is vowel then increment the window vowels
            if(vowels.contains(s.charAt(i)))
            {
                windowsVowels++;
            }

            // Check if current windows vowels are more than max vowels, then update the max vowels
            maxVowels = Math.max(maxVowels, windowsVowels);
        }
        return maxVowels;
    }
    
    public static void main(String[] args) {
		
    	String s = "abciiidef";
    	int k = 3;
    	
    	MaxVowelsInSubstrOfGivenLen maxVowelsInSubstrOfGivenLen = new MaxVowelsInSubstrOfGivenLen();
    	System.out.println(maxVowelsInSubstrOfGivenLen.maxVowels(s, k));
	}
}