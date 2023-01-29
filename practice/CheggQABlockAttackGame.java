package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CheggQABlockAttackGame {
	public static void main(String[] args)
	{
		//Get user inputs
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of attacks = ");
		int n = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter attacks (R, L, C or S) = ");
		String attacks = scan.nextLine();
		scan.close();
		
		List<String> valid_attacks = Arrays.asList(new String[]{"R", "L", "C", "S"});
		Map<String, String> attack_block = new HashMap<>();
		attack_block.put("C", "M");
		attack_block.put("L", "E");
		attack_block.put("R", "C");
		attack_block.put("S", "S");
		
		String[] attack_arr = attacks.split("\\s+");
		
		if(n != attack_arr.length)
		{
			System.out.println("Attacks entered does not match the attacks numbers");
			return;
		}
		
		Set<String> superAttack = new HashSet<>();
		
		List<String> counter_attack = new ArrayList<>();
		
		//Looping through each attack value
		for(int i = 0; i < n; i++)
		{
			//Check if the attack value is valid
			if(valid_attacks.contains(attack_arr[i]))
			{
				//Check for next 3 values to see if there is super attack
				if(i + 3 < n )
				{
					superAttack.add(attack_arr[i]);
					superAttack.add(attack_arr[i+1]);
					superAttack.add(attack_arr[i+2]);
					superAttack.add(attack_arr[i+3]);
					
					//Check if set size is 4 that means there is a super attack and hence add F as block
					if(superAttack.size() == 4)
					{
						counter_attack.add("F");
						superAttack.clear();
						i = i + 3;
					}
					else
					{
						//add respective block if there is no super attack
						counter_attack.add(attack_block.get(attack_arr[i]));
						superAttack.clear();
					}
				}
				else
				{
					counter_attack.add(attack_block.get(attack_arr[i]));
				}
			}
			else
			{
				System.out.println("Invalid attack value!!");
				return;
			}
		}
		
		String separator = "";
		for(String block : counter_attack)
		{
			System.out.print(separator+block);
			separator = " ";
		}
	}
}
