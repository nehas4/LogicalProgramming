package practice;

import java.util.PriorityQueue;

public class Worksheet4_Spring2020 {
	
	public static void main(String[] args) {
		
		// Code for #2
		PriorityQueue<Integer> integers = new PriorityQueue<>();
		
		
		// Code for #3
		PriorityQueue<PlayerW4> results = new PriorityQueue<>();
		
		PlayerW4 player1 = new PlayerW4("Frank");
		PlayerW4 player2 = new PlayerW4("Paul");
		
		player1.addScore(new ScoreW4(10500, "02/04/2020"));
		player1.addScore(new ScoreW4(50000, "11/27/2019"));
		player1.addScore(new ScoreW4(45900, "11/27/2019"));
		
		player2.addScore(new ScoreW4(33113, "03/31/2013"));
		player2.addScore(new ScoreW4(80720, "08/01/2019"));
		
		// Code for #4b
		results.add(player1);
		results.add(player2);
		
		
	}

}
