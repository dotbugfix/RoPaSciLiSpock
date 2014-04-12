package com.h2b2.ropascilispock.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.h2b2.ropascilispock.MainActivity;

public class ScoreMasterImpl implements IScorerMaster {
	/**
	 * Internal logger instance for this class
	 */
	private static final Logger _logger = LoggerFactory.getLogger(ScoreMasterImpl.class); 
	
	int [][] cResultArray;
	
	/**
	 * {@inheritDoc}
	 */
	public void init(int [][] mResultsArray) {
		this.cResultArray=mResultsArray; 
	}

	/**
	 * {@inheritDoc}
	 */
	public int calculateScores(EMoveList MY, EMoveList YOUR) {
		return this.cResultArray[MY.value][YOUR.value];	
	}
}
