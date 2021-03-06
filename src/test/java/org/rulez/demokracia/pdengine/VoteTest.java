package org.rulez.demokracia.pdengine;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.rulez.demokracia.pdengine.annotations.tested_behaviour;
import org.rulez.demokracia.pdengine.annotations.tested_feature;
import org.rulez.demokracia.pdengine.annotations.tested_operation;
import org.rulez.demokracia.pdengine.exception.ReportedException;
import org.rulez.demokracia.pdengine.testhelpers.CreatedDefaultChoice;

public class VoteTest extends CreatedDefaultChoice {

	@Before
	public void setUp() throws ReportedException {
		super.setUp();
	}


	@tested_feature("Vote")
	@tested_operation("Cast vote")
	@tested_behaviour("deletes the ballot with ballotId, so only one vote is possible with a ballot")
	@Test
	public void cast_vote_deletes_our_ballot() {
		String ballot = voteManager.obtainBallot(adminInfo.voteId, adminInfo.adminKey);
		List<RankedChoice> theCastVote = new ArrayList<RankedChoice>();
		Vote vote = getTheVote();
		voteManager.castVote(adminInfo.voteId,ballot,theCastVote);
		assertFalse(vote.ballots.contains(ballot));
		
	}

}
