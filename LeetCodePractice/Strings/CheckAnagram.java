import java.util.Scanner;
public class CheckAnagram{
  
  boolean isAnagram(String str1, String str2)
  {
    str1 = str1.toLowerCase();
    str2 = str2.toLowerCase();
    
    str1 = str1.replace(" ", "");
    str2 = str2.replace(" ", "");
    
    int[] counts = new int[26];
    
    for(int i=0; i<str1.length(); i++)
    {
      counts[str1.charAt(i) - 'a']++;
    }
    
    for(int i=0; i<str2.length(); i++)
    {
      counts[str2.charAt(i) - 'a']--;
    }
    
    for(int i=0; i<counts.length; i++)
    {
      if(counts[i] != 0)
      {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter first sentence: ");
    String str1 = sc.nextLine();
    
    System.out.println("Enter second sentence: ");
    String str2 = sc.nextLine();
    
    CheckAnagram ca = new CheckAnagram();
    boolean result = ca.isAnagram(str1,str2);
    if(result)
    {
      System.out.println("Given 2 sentences are Anagram!!");
    }
    else
    {
        System.out.println("Given 2 sentences are Not Anagram!!");
    }
  }
}
