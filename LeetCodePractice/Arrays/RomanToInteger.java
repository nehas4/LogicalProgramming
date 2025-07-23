package LeetCodePractice.Arrays;

import java.util.HashMap;

public class RomanToInteger {

	// This function returns the integer value given to corresponding Roman value
	// Roman numerals are usually written largest to smallest from left to right. Except certain exceptional cases like numeral for four is not IIII but IV. Because the one is before the five we subtract it making four.
	// So we store the Roman char to related integer map
	// Loop through each character in the Roman value and if current value is less than next one then subtract from result, else add
    public int romanToInt(String s) {

        HashMap<Character, Integer> romanCharMap = new HashMap<>();
        romanCharMap.put('I', 1);
        romanCharMap.put('V', 5);
        romanCharMap.put('X', 10);
        romanCharMap.put('L', 50);
        romanCharMap.put('C', 100);
        romanCharMap.put('D', 500);
        romanCharMap.put('M', 1000);

        if(s.length() == 1)
        {
            return romanCharMap.get(s.charAt(0));
        }

        int result = 0;
        for(int i=0; i<s.length(); i++)
        {
            if((i+1 < s.length()) && (romanCharMap.get(s.charAt(i)) < romanCharMap.get(s.charAt(i+1))))
            {
                result -= romanCharMap.get(s.charAt(i));
            }
            else
            {
                result += romanCharMap.get(s.charAt(i));
            }
        }
        return result;
    }
}
