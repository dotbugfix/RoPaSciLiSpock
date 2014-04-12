package com.h2b2.ropascilispock.game;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.h2b2.ropascilispock.MainActivity;
import com.h2b2.ropascilispock.R;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

public class GameplayImpl extends Game implements IGameplay {
	
	/**
	 * Internal logger instance for this class
	 */
	private static final Logger _logger = LoggerFactory.getLogger(GameplayImpl.class); 

	public GameplayImpl(Activity activity) {
		_activity = activity;
	}

	/**
	 * {@inheritDoc}
	 */
	public void playRock() {
		_logger.info("Current player played ROCK!");
	}

	/**
	 * {@inheritDoc}
	 */
	public void playPaper() {
		_logger.info("Current player played PAPER!");
	}

	/**
	 * {@inheritDoc}
	 */
	public void playScissors() {
		_logger.info("Current player played SCISSORS!");
	}

	/**
	 * {@inheritDoc}
	 */
	public void playLizard() {
		_logger.info("Current player played LIZARD!");
	}

	/**
	 * {@inheritDoc}
	 */
	public void playSpock() {
		_logger.info("Current player played SPOCK!");
	}
}
