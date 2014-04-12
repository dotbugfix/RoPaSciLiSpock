package com.h2b2.ropascilispock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.h2b2.ropascilispock.game.IGameplay;

import android.app.Fragment;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class PlayTabFragment extends Fragment {
	/**
	 * Internal logger instance for this class
	 */
	private static final Logger _logger = LoggerFactory
			.getLogger(PlayTabFragment.class);

	/**
	 * Gameplay instance
	 */
	private IGameplay _gameplay = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.play_tab, container, false);

		return rootView;
	}

	/**
	 * Play the 'Rock' move in the current game
	 * 
	 * @param view
	 *            Originating GUI widget
	 */
	public void playRock(View view) {
		Toast.makeText(getActivity().getApplicationContext(),
				"You played ROCK!", Toast.LENGTH_SHORT).show();
		_gameplay.playRock();
	}

	/**
	 * Play the 'Paper' move in the current game
	 * 
	 * @param view
	 *            Originating GUI widget
	 */
	public void playPaper(View view) {
		Toast.makeText(getActivity().getApplicationContext(),
				"You played PAPER!", Toast.LENGTH_SHORT).show();
		_gameplay.playPaper();
	}

	/**
	 * Play the 'Scissors' move in the current game
	 * 
	 * @param view
	 *            Originating GUI widget
	 */
	public void playScissors(View view) {
		Toast.makeText(getActivity().getApplicationContext(),
				"You played SCISSORS!", Toast.LENGTH_SHORT).show();
		_gameplay.playScissors();
	}

	/**
	 * Play the 'Lizard' move in the current game
	 * 
	 * @param view
	 *            Originating GUI widget
	 */
	public void playLizard(View view) {
		Toast.makeText(getActivity().getApplicationContext(),
				"You played LIZARD!", Toast.LENGTH_SHORT).show();
		_gameplay.playLizard();
	}

	/**
	 * Play the 'Spock' move in the current game
	 * 
	 * @param view
	 *            Originating GUI widget
	 */
	public void playSpock(View view) {
		Toast.makeText(getActivity().getApplicationContext(),
				"You played SPOCK!", Toast.LENGTH_SHORT).show();
		_gameplay.playSpock();
	}

	/**
	 * Reset the timer for the current round
	 * 
	 * @param view
	 *            Originating GUI widget
	 */
	public void resetTimer(View view) {
		Toast.makeText(getActivity().getApplicationContext(), "Reset Timer...",
				Toast.LENGTH_SHORT).show();

		new CountDownTimer(5000, 100) {

			public void onTick(long millisUntilFinished) {
				TextView timerText = (TextView) getActivity().findViewById(
						R.id.textViewTimer);
				timerText.setText("" + millisUntilFinished / 1000 + ":"
						+ (millisUntilFinished / 100));
			}

			public void onFinish() {
				TextView timerText = (TextView) getActivity().findViewById(
						R.id.textViewTimer);
				timerText.setText("Round Done!");
			}
		}.start();

	}

	public IGameplay get_gameplay() {
		return _gameplay;
	}

	public void set_gameplay(IGameplay _gameplay) {
		this._gameplay = _gameplay;
	}
}
