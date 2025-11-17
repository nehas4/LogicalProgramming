package LeetCodePractice.Arrays;

/*
 * [LeetCode 1528]
 * 
 * Given a string and an array of indices. The indices determine the position of each character in the restored string. Find the restored string.
 * 
 * We can use map to store the index as key and related character as value, then loop through the map and create the string starting from 0 index to last index.
 * In the above approach we are using a extra structure so space overhead is there.
 * Instead we can use a simple a array of characters.
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 * 
 * */
public class ShuffleString {
	
	/*
	 * In this approach we will be using a array of characters to store the characters at each index.
	 * By looking at the length of string we know that there will be total how many number of indices.
	 * Using this info we will loop through the index array and get the related character to place.
	 * 
	 * */
    public String restoreString(String s, int[] indices) {
        
    	char[] str = new char[s.length()];
    	
    	for(int i=0; i<indices.length; i++)
    	{
    		// Get the current value from array and at that value store the current character
    		str[indices[i]] = s.charAt(i);
    	}
    	
    	return String.valueOf(str);
    }
    
    public static void main(String[] args) {
		
    	String s = "rockslife";
    	int[] indices = {4,5,6,7,8,0,1,2,3};
    	
    	ShuffleString shuffleString = new ShuffleString();
    	System.out.println("Restored string is "+shuffleString.restoreString(s, indices));
    	
	}

}
