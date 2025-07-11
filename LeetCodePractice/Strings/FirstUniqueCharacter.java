import java.util.HashMap;
import java.util.Scanner;
public class FirstUniqueCharacter {
  
  // Function to find first unique character in a string
  // Use map to save each character in the string and its related frequency
  // loop through map and the first character with 1 as frequency is the result
  int firstUniqChar(String str)
  {
    int index = 0;
    HashMap<Character,Integer> charCntMap = new HashMap<>();
    
    for(int i=0; i<str.length(); i++)
    {
      charCntMap.put(str.charAt(i), charCntMap.getOrDefault(str.charAt(i), 0)+1);
    }
    
    for(int i=0; i<str.length(); i++)
    {
      if(charCntMap.get(str.charAt(i)) == 1)
      {
        index = i;
        break;
      }
    }
    return index;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    FirstUniqueCharacter obj = new FirstUniqueCharacter();
    int index = obj.firstUniqChar(str);
    System.out.println("First unique character found for string "+str+" at index "+index+" is "+str.charAt(index));
  }
}
