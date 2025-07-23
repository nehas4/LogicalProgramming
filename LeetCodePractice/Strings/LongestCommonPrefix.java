package LeetCodePractice.Strings;

public class LongestCommonPrefix {
	
	
	// This function returns the longest common prefix in all the strings in a given string array
	// Prefix means a common substring that all the string starts with
	// We will consider the first whole word as prefix first, thinking that all other strings starts with the same
	// Then loop through rest of the strings in array and check if it starts with the current prefix, if not then decrement a character from end from prefix and check again
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        int i=1;
        while(i < strs.length)
        {
            if (!strs[i].startsWith(prefix))
            {
                prefix = prefix.substring(0, prefix.length()-1);
            }
            else
            {
                i++;
            }
        }
        return prefix;
    }

}
