package LeetCodePractice.Arrays;

public class GasStation {
	
	// Given array of amount of gas at each station in one array, and cost of reaching to next station from current station in one array
	// Return the start point gas station from where you can complete a circuit of gas station
	// Below is the greedy approach to find solution
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int totalGas = 0;
    	int totalCost = 0;
    	for(int i=0; i<gas.length; i++)
    	{
    		totalGas += gas[i];
    		totalCost += cost[i];
    	}
    	
    	// In case total gas is greater than total cost then completing the circuit is not possible
    	if(totalCost> totalGas)
    	{
    		return -1;
    	}
    	
    	// Loop through each gas station
    	// At any point if current gas is negative, means cost is more than current gas, then change the start point index after current index
    	int start_point = 0;
    	int curr_gas = 0;
    	for(int i=0; i<gas.length; i++)
    	{
    		curr_gas += gas[i]-cost[i];
    		if(curr_gas < 0)
    		{
    			start_point=i+1;
    			curr_gas = 0;
    		}
    	}
    	return start_point;
    }
    
    
    public static void main(String[] args) {
		int[] gasArr = new int[] {1,2,3,4,5};
		int[] costArr = new int[] {3,4,5,1,2};
		
		GasStation gs = new GasStation();
		System.out.println("Starting gas staion index from where circuit can be completed is "+gs.canCompleteCircuit(gasArr, costArr));
	}

}
