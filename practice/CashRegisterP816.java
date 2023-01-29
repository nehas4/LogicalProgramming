package practice;

public class CashRegisterP816
{
    // TODO: insert declarations of instance variables
	
	//instance variable to store the max item numbers in one sale
	int capacity = 0;
	
	int itemCount = 0;
	
	//instance variable to save all the items price in one sale
	double[] itemsPrice = new double[capacity];
	
    /**
     * Constructor for objects of class CashRegisterP816
     * 
     * @param capacity the maximal number of items the cash register can store
     */
    public CashRegisterP816(int capacity)
    {
    	//using parameter to set the item capacity number and create array of the same capacity
    	this.capacity = capacity;
    	
    	// Setting initial item count as 0
    	this.itemCount = 0;
    	
    	// Here by default all the array value from index 0 to capacity-1 will be set to default 0.0 value
        this.itemsPrice = new double[this.capacity];
    }
    
    /**
     * Constructor for objects of class CashRegisterP816 
     * (with the default capacity)
     */
    public CashRegisterP816()
    {
    	// Setting default item capacity number and creating array of the same capacity
    	this.capacity = 42;
    	
    	// Setting initial item count as 0
    	this.itemCount = 0;
    	
    	// Here by default all the array value from index 0 to 41 will be set to default 0.0 value
    	this.itemsPrice = new double[this.capacity];
    }

    /**
     * Gets the number of items in the current sale
     * 
     * @return the item count
     */
    public int getCount()
    {
    	//returning the count of items price value entered
        return this.itemCount;
    }
    
    /**
     * Gets the price of all items in the current sale
     * 
     * @return the total price
     */
    public double getTotal()
    {
    	double total = 0;
    	//Looping to sum each item value and save in the total
        for(int i = 0; i < this.itemCount; i++)
        {
        	total = total + this.itemsPrice[i];
        }
        
        return total;
    }
    
    /**
     * Clears the cash register before the next sale 
     */
    public void clear() 
    {
    	//To clear the register assigning capacity as zero and item price array as null
    	this.capacity = 0;
    	this.itemCount = 0;
        this.itemsPrice = new double[capacity];
    }    
    
    /**
     * Adds an item to the cash register
     * 
     * @param price the price of the item
     */
    public void addItem(double price) 
    {
    	// Checking if the array length is less than the item capacity defined
    	// Also checking if the price to be added is not zero or negative number
        if(this.itemCount < this.capacity && price > 0.0)
        {
        	// Adding positive price value to array at the next index of current count
        	this.itemsPrice[this.itemCount] = price;
        	
        	//Increment the item count since one item added
        	this.itemCount = this.itemCount + 1;
        }
    }    
    
    /**
     * Cancels the last item in the cash register
     */
    public void cancelLast()
    {
    	// First checking if array is not empty by checking its length to be greater than zero
        if(this.itemCount > 0)
        {
        	// Assigning the last value as default 0.0 to remove it from the item count
        	this.itemsPrice[this.itemCount - 1] = 0.0;
        	
        	//Decrement item count value as last price value is removed
        	this.itemCount = this.itemCount - 1; 
        }
    }    
    
    /**
     * Prints out all the items in the current sale
     */
    public void displayAll()
    {
        System.out.println("Price of all the items in current sale are:-");
        
        //Looping till the item count value to print each price value with item no
        for(int i = 0; i < this.itemCount; i++)
        {
        	System.out.println("Item "+ (i+1) +" price = "+ this.itemsPrice[i]);
        }
    }    
}
