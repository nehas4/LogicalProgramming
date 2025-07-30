package LeetCodePractice.Arrays;

/*
 * Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.
 * 
 * */

// Create a node class that will act as a node of a linked-list that will contain the price and its related span
class node{
    int price;
    int span;
    node next;
    node(int price,int span){
        this.price=price;
        this.span=span;
        this.next=null;
    }
}

// This class will initialize the prices and calculate the span for each price
public class StockSpanner {
	
    node top;
    
    public StockSpanner() {
        top=null;
    }
    
    // In this function once we get new price we create a new node and check its price against previous nodes prices by looping through linked list and adding up span if top price is less than current price
    public int next(int price) {
        node nn;
        int span=1;
        while(top!=null && top.price<=price){
            span+=top.span;
            top=top.next;
        }
        // Create new node now with calculated span
        nn=new node(price,span);
        nn.next=top;
        top=nn;
        return top.span;
    }
    
    public static void main(String[] args) {
		StockSpanner stockSpanner = new StockSpanner();
		stockSpanner.next(100);
		stockSpanner.next(80);
		stockSpanner.next(60);
		stockSpanner.next(70);
		stockSpanner.next(60);
		stockSpanner.next(75);
		int span = stockSpanner.next(85);
		System.out.println("Current span is "+span);
	}
}

