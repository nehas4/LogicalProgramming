package practice;

import java.util.LinkedList;
import java.util.Queue;

public class PlayerW4 implements Comparable<PlayerW4> {
	
	private String name;
	private Queue<ScoreW4> scores = new LinkedList<>();
	
	public PlayerW4(String name) {
		super();
		this.name = name;
	}
	
	// Code for 4.a
	// Returns the no of scores for current player object
	public int getScoresSize() {
		
		return scores.size();
	}
	
	// Add the score to current player object
	public void addScore(ScoreW4 score) {
		
		this.scores.add(score);
	}

	// Returns the particular score at the head of scores queue
	public ScoreW4 getScore() {
		return this.scores.peek();
	}

	@Override
	public int compareTo(PlayerW4 playerW4) {
		return Integer.compare(this.getScoresSize(), playerW4.getScoresSize());
	}
}
