package com.h2b2.ropascilispock;

public class Player {
	private String cName;
	private int cScore;
	
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public int getcScore() {
		return cScore;
	}
	public void setcScore(int cScore) {
		this.cScore = cScore;
	}
	public void updatecScore(int cScore) {
		this.cScore += cScore;
	}
}
