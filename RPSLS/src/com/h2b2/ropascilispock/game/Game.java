package com.h2b2.ropascilispock.game;

import java.util.List;

import android.app.Activity;

/**
 * Represents a Game
 *
 */
public class Game {
	
	/**
	 * Instance of @MainActivity
	 */
	protected Activity _activity;
	
	/**
	 * Rivals
	 */
	protected List<Player> _otherplayers;
	
	/**
	 * Self Player
	 */
	protected Player _selfPlayer;
	
	/**
	 * Scoring logic
	 */
	protected IScorerMaster _scoreMaster;
}
