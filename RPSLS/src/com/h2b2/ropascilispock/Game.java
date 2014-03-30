package com.h2b2.ropascilispock;

import java.util.List;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

public class Game {
	Activity cActivity;
	List<Player> cPlayers;
	Player me;
	ScoreMasterImpl cScoreMaster;
	
	Game(Activity activity) {
		cActivity = activity;
	}
	
	public void playRock() {
		Toast.makeText(cActivity.getApplicationContext(), "You played ROCK!", Toast.LENGTH_SHORT).show();
	}
	
	public void playPaper() {
		Toast.makeText(cActivity.getApplicationContext(), "You played PAPER!", Toast.LENGTH_SHORT).show();
	}
	
	public void playScissors() {
		Toast.makeText(cActivity.getApplicationContext(), "You played SCISSORS!", Toast.LENGTH_SHORT).show();
	}
	
	public void playLizard() {
		Toast.makeText(cActivity.getApplicationContext(), "You played LIZARD!", Toast.LENGTH_SHORT).show();
	}
	
	public void playSpock() {
		Toast.makeText(cActivity.getApplicationContext(), "You played SPOCK!", Toast.LENGTH_SHORT).show();
	}
}
