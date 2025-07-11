import java.util.Scanner;
public class LongestPalindrome {
  
  // Function to evaluate the longest palindrome in a given string
  // Maintain 2 pointers and for each index move both the pointers in left right direction until same charater
  // compare each pointer palindrome with previous one and take longest
  // Do above for both cases: even and odd length
  String longestPalindrome(String str)
  {
    if (str.length() <= 1)
    {
      return str;
    }
    String LPS="";
    
    for (int i=1; i < str.length(); i++)
    {
      // For odd length scnerios
      int low=i;
      int high=i;
      
      while(str.charAt(low) == str.charAt(high))
      {
        low--;
        high++;
      
        if (low == -1 || high == str.length())
        {
          break;
        }
      }
      
      String currPalindrome = str.substring(low+1, high);
      if (currPalindrome.length() > LPS.length())
      {
        LPS=currPalindrome;
      }
      
      // For even length scenario
      low = i-1;
      high = i;
      
      while(str.charAt(low) == str.charAt(high))
      {
        low--;
        high++;
      
        if (low == -1 || high == str.length())
        {
          break;
        }
      }
      
      currPalindrome = str.substring(low+1, high);
      if (currPalindrome.length() > LPS.length())
      {
        LPS=currPalindrome;
      }
    }
    return LPS;
  }
  
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    String input = sc.next();
    LongestPalindrome lp = new LongestPalindrome();
    String result = lp.longestPalindrome(input);
    
    System.out.println("Longest palindrome for string: "+input+" is "+result);
  }
}
