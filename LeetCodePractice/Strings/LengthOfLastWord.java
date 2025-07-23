package LeetCodePractice.Strings;

public class LengthOfLastWord {
	
	// This function returns the length of last word in a given string
	// Trim the string first to remove the leading and trailing spaces
	// Loop each character of string from last and count the characters until first space found
    public int lengthOfLastWord(String s) {
        int wordCnt = 0;
        s=s.strip();
        for(int i=s.length()-1; i>=0; i--)
        {
            if(s.charAt(i) != ' ')
            {
                wordCnt++;
            }
            else
            {
                break;
            }
        }
        return wordCnt;
    }

}
