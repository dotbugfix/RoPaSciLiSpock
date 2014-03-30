package com.h2b2.ropascilispock;

public enum EMoveList {
	ML_ROCK(0),ML_PAPER(1),ML_SCISSOR(2),ML_LIZARD(3),ML_SPOCK(4);
	
	public final int value;
	private EMoveList(final int value) {
		this.value=value;
	}
}
