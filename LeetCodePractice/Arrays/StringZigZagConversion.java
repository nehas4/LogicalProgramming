package LeetCodePractice.Arrays;

public class StringZigZagConversion {
	
	/* The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
	P   A   H   N
	A P L S I I G
	Y   I   R
	And then read line by line: "PAHNAPLSIIGYIR"
	Write the code that will take a string and make this conversion given a number of rows */
	// For this problem first we are creating string array of numRows to store string at each row after zig-zag
	// Loop through each character in string
	// Inside above loop, have 2 loops, one to go down in zig-zag pattern and one to go above
	// This way we append each character at particular row
	// We go down numRows times and up numRows-2 times leaving the first and last row
	// After that concatenate all the rows string in sequence to get result string
    public String convert(String s, int numRows) {
    	
    	StringBuilder[] sbArr = new StringBuilder[numRows];
    	
    	for(int i=0; i<numRows; i++)
    	{
    		sbArr[i] = new StringBuilder();
    	}
    	
    	int index = 0;
    	while(index < s.length())
    	{
    		for(int j=0; j<numRows && index < s.length(); j++)
    		{
    			sbArr[j].append(s.charAt(index));
    			index++;
    		}
    		
    		for(int j=numRows-2; j>0 && index < s.length(); j--)
    		{
    			sbArr[j].append(s.charAt(index));
    			index++;
    		}
    	}
    	
    	StringBuilder sb = sbArr[0];
    	for(int i=1; i<numRows; i++)
    	{
    		sb.append(sbArr[i]);
    	}
    	return sb.toString();
    }
    
    public static void main(String[] args) {
		StringZigZagConversion zigZag = new StringZigZagConversion();
		System.out.println("Output after zig-zag conversion of PAYPALISHIRING with 4 rows is "+zigZag.convert("PAYPALISHIRING", 4));
	}

}
