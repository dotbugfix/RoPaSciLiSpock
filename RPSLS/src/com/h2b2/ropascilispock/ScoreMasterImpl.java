package com.h2b2.ropascilispock;

public class ScoreMasterImpl implements IScorerMaster {
	
	int [][] cResultArray;
	public void init(int [][] mResultsArray) {
		this.cResultArray=mResultsArray; 
	}

	public int calculateScores(EMoveList MY, EMoveList YOUR) {
		return this.cResultArray[MY.value][YOUR.value];	
	}
}
