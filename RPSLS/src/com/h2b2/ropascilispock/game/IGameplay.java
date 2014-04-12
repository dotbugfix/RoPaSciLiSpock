package com.h2b2.ropascilispock.game;

public interface IGameplay {
	/**
	 * Play the @EMoveList.ML_ROCK move
	 */
	public void playRock();
	
	/**
	 * Play the @EMoveList.ML_PAPER move
	 */
	public void playPaper();
	
	/**
	 * Play the @EMoveList.ML_SCISSOR move
	 */
	public void playScissors();
	
	/**
	 * Play the @EMoveList.ML_LIZARD move
	 */
	public void playLizard();
	
	/**
	 * Play the @EMoveList.ML_SPOCK move
	 */
	public void playSpock();
}
