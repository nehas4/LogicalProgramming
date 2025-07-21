package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main 
{
	static private HashMap<String, String> hexMap = new HashMap<>();
	
	public static void main(String[] args) 
	{
		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		map.put(1, set);
		set = new HashSet<Integer>();
		set.add(1);
		set.add(3);
		map.put(2, set);
		set = new HashSet<Integer>();
		set.add(3);
		set.add(4);
		map.put(3, set);
		set = new HashSet<Integer>();
		set.add(3);
		set.add(5);
		map.put(4, set);

		HashSet<Integer> set1 = map.get(1);
		Iterator<Integer> it1 = set1.iterator();
		while(it1.hasNext())
		{
			Integer i = it1.next();
			HashSet<Integer> set2 = map.get(i);
			if(set2.contains(i))
			{
				HashSet<Integer> newSet = new HashSet<>(set2);
				newSet.remove(1);

				map.put(i, newSet);
			}
		}
		
		int X=6;
		int Y=10;
		int i = X;
		if((X+i)%(Y+i) == 0)
		{
			System.out.println("Yes");
		}
		else
		System.out.println("No");
		
	}
	
	public LinkedHashMap abc()
	{
		return new LinkedHashMap<>();
	}
	
	public void put(Map map)
	{
		System.out.println("Success");
	}
}