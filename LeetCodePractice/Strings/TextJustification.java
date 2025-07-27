package LeetCodePractice.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 * */
public class TextJustification {
	
	// In this solution, we maintain a list containing current words to form a line
	// Also maintain a counter for total length of words for current line
    public List<String> fullJustify(String[] words, int maxWidth) {
    	
    	List<String> result = new ArrayList<>();
    	List<StringBuilder> currWords = new ArrayList<>();
    	int sumOfCurrWordsLen = 0;
    	
    	for(String word : words)
    	{
    		// Get the length till now in current line by adding new word length + existing line length + words count (for number of spaces in between)
    		int currWordsLen = word.length() + sumOfCurrWordsLen + currWords.size();
    		// Check if above count is greater than given max width
    		if(currWordsLen > maxWidth)
    		{
    			// Check if extra space need to be added by: max width - length of words till now + words count - 1 --> (to only take space in between in account)
    			int extraSpaces = maxWidth - (sumOfCurrWordsLen + currWords.size() -1);
    			// Get this total count of spaces in between words
    			int wordsToRoundRobinSpaces = Math.max(currWords.size() -1, 1);
    			// Loop through the number of extra spaces
    			for(int i=0; i<extraSpaces; i++)
    			{
    				// Get the index at which space need to be added
    				int indexToSpace = i % wordsToRoundRobinSpaces;
    				// Add spaces with words at particular indexes
    				currWords.get(indexToSpace).append(" ");
    			}
    			// add newly formed line in result by joining the current words with single space
    			result.add(currWords.stream().map(sb -> sb.toString()).collect(Collectors.joining(" ")));
    	    	// Reset the current words list and sum of total words length also
    			currWords = new ArrayList<>();
    	    	sumOfCurrWordsLen = 0;
    		}
    		// Add new word to current words list and increment words length counter
    		currWords.add(new StringBuilder(word));
    		sumOfCurrWordsLen += word.length();
    	}
    	
    	// Below code take cares the last line
    	// Check if last line length is less than max width
    	String spaces = "";
    	if (sumOfCurrWordsLen < maxWidth)
    	{
    		// Calculate the space to be added in the end of last word
    		int spaceToAdd = maxWidth - (sumOfCurrWordsLen + currWords.size() -1);
    		// Create spaces string with number of spaces to be appended
    		spaces = Stream.generate(() -> " ").limit(spaceToAdd).collect(Collectors.joining(""));
    		// Add spaces at the end of last line
    		
    	}
    	result.add(currWords.stream().map(sb -> sb.toString()).collect(Collectors.joining(" ")) + spaces);
    	return result;
    }
    
    
    // Below is faster solution for this problem
    int MAX_WIDTH;
    public List<String> fullJustify_faster(String[] words, int maxWidth)
    {
        MAX_WIDTH = maxWidth;
        List<String> result = new ArrayList<String>();
        int n = words.length;
        int i = 0, j = 0;
        int currWordsLen = 0;
        // Loop through each word in given array
        while(i < n)
        {
            j = i+1;
            // Take the character length of current array
            currWordsLen = words[i].length();
            int currWordsNo = 0;
            // Check if next character: j exists and
            // If current words character length + next word character length + 1 for space is not greater than given maxWidth
            while(j < n && currWordsLen + words[j].length() + currWordsNo + 1 <= MAX_WIDTH )
            {
            	// Increment the current word character length take next word J into consideration
                currWordsLen += words[j].length();
                // Increment num of words counter
                currWordsNo++;
                // Increment j pointer to check next word in next loop
                j++;
            }

            // Get remaining spaces by taking the difference of current words character length difference with max width
            int remainingSpaces = MAX_WIDTH - currWordsLen;
            // Get the equal number of total spaces to add in between each word by dividing remaining spaces with current no of words
            int spacesToAdd = currWordsNo == 0 ? 0: remainingSpaces / currWordsNo;
            // Get the the extra spaces left after putting equally no of spaces by doing modulo of remaining spaces with current no of words
            int extraSpaces = currWordsNo == 0 ? 0: remainingSpaces % currWordsNo;

            // If j is the last word, then we need to add single space between words and making extra space to add as 0, to be later added at the end
            if(j == n)
            {
                spacesToAdd = 1;
                extraSpaces = 0;
            }

            // Call function to get current line by passing currently derived start, end index, spaces to add, extra spaces, words array 
            String line = getCurrLine(i, j, spacesToAdd, extraSpaces, words);

            // Add current line in result list
            result.add(line);
            // Start the next loop with index next to current line index i.e., j
            i=j;
        }
        // Return result
        return result;
    }
    
    // This is a helper function for the above fully justify function to get the current line by checking start, end index and adding required no of spaces with spacesToAdd and extraSpaces value
    private String getCurrLine(int i, int j, int spacesToAdd, int extraSpaces, String[] words)
    {
        StringBuilder sb = new StringBuilder();
        // Loop from i to j (start to end index from argument)
        while(i < j)
        {
        	// Append current word to string builder
            sb.append(words[i]);
            
            // Break from loop if current index is last index
            if(i == j-1)
            {
                break;
            }

            // Loop through no of spaces to add (to be equally distributed) and append those number of spaces after current word
            for(int k=0; k<spacesToAdd; k++)
            {
                sb.append(" ");
            }

            // If there are any extra space to be added then append that also to current word and decrement extra space counter
            if(extraSpaces > 0)
            {
                sb.append(" ");
                extraSpaces--;
            }
            
            // Increment i counter to check next word in next loop 
            i++;
        }

        // After the above loop check, loop till currently found line character length is less than max width, then append the result of the length with spaces
        while(sb.length() < MAX_WIDTH)
        {
            sb.append(" ");
        }
        // Return currently formed line
        return sb.toString();
    }
    

    public static void main(String[] args) {
		TextJustification tj = new TextJustification();
		String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
		//String[] words = {"a"};
		List<String> result = tj.fullJustify_faster(words, 20);
		for(String line : result)
		{
			System.out.println("["+line+"]");
		}
	}
}
