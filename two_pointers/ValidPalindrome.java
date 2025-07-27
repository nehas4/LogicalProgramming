package two_pointers;


/*
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.
 * */
public class ValidPalindrome {
	
	// This function returns true if given string is a palindrome, else false
	// This function only checks alpha-numeric characters only in string
    public boolean isPalindrome(String s) {
    	
    	s = s.toLowerCase(); // Convert all characters to lower-case
    	String strToCheck = s.toLowerCase().replaceAll("[^a-z0-9]", ""); // Replace all non-alphanumeric characters
    	
    	// Maintain 2 pointers, one to point to starting index, other to point at last index
    	int i = 0;
    	int j = strToCheck.length() - 1;
    	
    	while(i < j)
    	{
    		// In case of current start and end character is not same return false
    		if (strToCheck.charAt(i) != strToCheck.charAt(j))
    		{
    			return false;
    		}
    		
    		// Move i forward and j backwards
    		i++;
    		j--;
    	}
        
    	// If above loop complete successfully, then it means its a palindrome and return true
    	return true;
    }
    
    public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama";
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(str);
		System.out.println("Is above string a palindome: "+vp.isPalindrome(str));
	}

}
