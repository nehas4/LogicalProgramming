package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheggQACheckList {
	
	public static void main(String[] args) 
	{
		Integer[] number_array = {3, 3, 28, 27, 14, 27, 6, 19, 12, 12, 25, 
								6, 9, 15, 9, 23, 19, 23, 3, 27, 9, 24, 22, 
								6, 0, 25, 3, 23, 20, 25, 22, 14, 29, 21, 
								1, 2, 22, 12, 1, 7, 18, 26, 17, 6, 10, 
								12, 8, 23, 20, 22, 4, 5, 8, 1, 25, 9, 8, 
								4, 29, 13};
		List<Integer> number_list = Arrays.asList(number_array);
		
		Integer[] check_array = {2, 34, 29, 17, 17, 29, 23, 27, 30, 26};
		List<Integer> check_list = Arrays.asList(check_array);
		
		List<Integer> answer_List = new ArrayList<>();
		for(Integer values : number_list)
		{
			if(check_list.contains(values))
			{
				answer_List.add(values);
			}
		}
		
		System.out.println("Total no of number_list elements found in check_list = "+answer_List.size());
	}

}
