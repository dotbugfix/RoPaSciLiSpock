package com.h2b2.ropascilispock.game;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScoreMasterImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInit() {
		int [][] a={{0,-1,1},{1,0,-1},{-1,1,0}};
		ScoreMasterImpl scoreMaster=new ScoreMasterImpl();
		scoreMaster.init(a);
	}

	@Test
	public void testCalculateScores() {
		int [][] a={{0,-1,1},{1,0,-1},{-1,1,0}};
		ScoreMasterImpl scoreMaster=new ScoreMasterImpl();
		scoreMaster.init(a);
		Logger logger = LoggerFactory.getLogger(ScoreMasterImpl.class);
	    logger.info("Hello World");
		assertEquals("Error",-1, scoreMaster.calculateScores(EMoveList.ML_ROCK, EMoveList.ML_PAPER));
		assertEquals("Error",1, scoreMaster.calculateScores(EMoveList.ML_SCISSOR, EMoveList.ML_PAPER));
		assertEquals("Error",-1, scoreMaster.calculateScores(EMoveList.ML_SCISSOR, EMoveList.ML_ROCK));
		assertEquals("Error",0, scoreMaster.calculateScores(EMoveList.ML_PAPER, EMoveList.ML_PAPER));
	}
}
