package two_pointers;


/*
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 * */
public class IsSubsequence {
	
	// Below function checks and returns true if s is sub-sequence of t
    public boolean isSubsequence(String s, String t) {
        
    	int i = 0, j = 0, sn = s.length(), tn = t.length();
    	
    	// If s is empty then return true as by default empty string is a substring of any string
    	if (sn == 0)
    	{
    		return true;
    	}
    	// If t is empty then s can't be substring of it, so return false
    	if(tn == 0)
    	{
    		return false;
    	}
    	
    	// Loop to check each character from s in t
    	while(i < sn && j < tn)
    	{
    		// If s character is in t then move the s string pointer ahead
    		if (s.charAt(i) == t.charAt(j))
    		{
    			i++;
    		}
    		
    		// If we s string pointer reach till end of string, means its a sub-sequence and return true
    		if(i == sn)
    		{
    			return true;
    		}
    		
    		// Move t string pointer ahead irrespective
    		j++;
    	}
    	
    	return false;
    }
    
    public static void main(String[] args) {
		
    	String s = "abc";
    	String t = "ahbgdc";
    	
    	IsSubsequence isSubsequence = new IsSubsequence();
    	System.out.println("String 1 : "+s);
    	System.out.println("String 2 : "+t);
    	System.out.println("Is string 1 is sub-sequence of string 2: "+isSubsequence.isSubsequence(s, t));
	}

}
