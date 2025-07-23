package LeetCodePractice.Arrays;

public class IntegerToRoman {
	
	// This solution converts an integer number to its corresponding Roman number
	// So for this we save numbers in one list and related Roman values in another list
	// We are saving the intermediate values as well where smaller value char comes before larger one
	// We loop through the integer array and we check if given number is greater than current integer value, then append the related Roman string. Also subtract the integer from value till number is more than integer, after that move forward in array and do the same
	// 
    public String intToRoman(int num) {

        int[] number = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<number.length && num > 0; i++)
        {
            while(num >= number[i])
            {
                sb.append(roman[i]);
                num -= number[i];
            }
        }
        return sb.toString();
    }

}
