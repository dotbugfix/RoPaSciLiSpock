package com.h2b2.ropascilispock.game;

public interface IScorerMaster {
	
	/**
	 * Initialize the scoring logic
	 * 
	 * @param resultArray Score Template
	 */
	public void init(int[][] resultArray);
	
	/**
	 * Calculate score based on moves
	 * 
	 * @param my  Current player's move
	 * @param your  Opponent's move
	 * @return    Current player's score for this move
	 */
	public int calculateScores(EMoveList my,EMoveList your);
}
