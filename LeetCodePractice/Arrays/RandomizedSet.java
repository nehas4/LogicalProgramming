package LeetCodePractice.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


/**
 * Create a RandomizedSet class which will have following features and all functions should be executed in O(1) time complexity:-
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// To achieve above, we will maintain a map that will contain number element as key and and its related index as value
// We can do insert and remove in O(1) time but to get a random element from map is not possible as there is no concept of index in it
// For that maintain a list which will have value at its particular index and we can use random function on its size and return a random value
class RandomizedSet {
    List<Integer> numList;
    HashMap<Integer, Integer> numMap;
    Random random = new Random();

    public RandomizedSet() {
    	numList = new ArrayList<Integer>();
    	numMap = new HashMap<>();
    }
    
    // Insert value in map as key and latest index as value
    // Insert value in list as well
    public boolean insert(int val) {
    	if(numMap.containsKey(val))
    	{
    		return false;
    	}
    	else
    	{
    		numMap.put(val, numList.size());
    		numList.add(val);
    		return true;
    	}
    }
    
    // Get index of value to be removed from map
    // get last index value from list
    // put last index value as remove element index in list and update its related index-value in map
    // remove from map and list
    public boolean remove(int val) {
    	if(numMap.containsKey(val))
    	{
    		int idx = numMap.get(val);
    		if(idx != (numList.size()-1))
    		{
    			int lastIdxVal = numList.get(numList.size()-1);
        		numList.set(idx, lastIdxVal);
        		numMap.put(lastIdxVal, idx);
    		}
    		numMap.remove(val);
    		numList.remove(numList.size()-1);
    		return true;
    	}
    	else
    	{
    		return false;
    	}
        
    }
    
    // Get random integer ranging from 0 to list size
    // return value at that random index
    public int getRandom() {
        return numList.get(random.nextInt(numList.size()));
    }
}
