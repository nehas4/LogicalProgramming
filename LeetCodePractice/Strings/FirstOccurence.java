package LeetCodePractice.Strings;

public class FirstOccurence {
	
	/*
	 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
	 * */
	// In this solution we check at each index if the substring starts with needle value,  if does returns index, else return -1
    public int strStr(String haystack, String needle) {
    	
    	int needleLen = needle.length();
    	for(int i=0; i<haystack.length(); i++)
    	{
    		String currSubStr = haystack.substring(i);
    		if(needleLen <= currSubStr.length() && currSubStr.startsWith(needle))
    		{
    			return i;
    		}
    	}
        return -1;
    }
    
    
    // This is faster way where we are looping through each character of haystack and checking it with each char of needle
    // If above condition does not satisfy then reset the i and j value depicting character index of haystack and needle respectively
    public int strStr_faster(String haystack, String needle) {
        int m = haystack.length(), n = needle.length(), i=0, j=0;

        while(i<m && j<n){
            if(haystack.charAt(i) == needle.charAt(j)){
                if(j == n-1) return i-j;
                i++;
                j++;
            }
            else{
                i = i-j+1;
                j=0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
		FirstOccurence fo = new FirstOccurence();
		System.out.println("First occurence found at "+fo.strStr("a", "a"));
	}
}
