package LeetCodePractice.Strings;

public class ReverseWordsInString {
	
	// This function returns all the words in a given string but in reversed order and with single space only
	// First trim the string and then split the string in words based on one or more spaces
	// Then loop through words array from end and append in result with single space
	// Then return the trimmed result to remove the extra space at the end
    public String reverseWords(String s) {
        String[] strArr = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=strArr.length-1; i>=0; i--)
        {
            sb.append(strArr[i]).append(" ");
        }
        return sb.toString().trim();
    }

}
