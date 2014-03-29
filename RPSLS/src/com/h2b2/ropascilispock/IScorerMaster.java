package com.h2b2.ropascilispock;

public interface IScorerMaster {
	
	public void init(int[][] resultArray);
	public int calculateScores(EMoveList my,EMoveList your);
}
