package br.com.caelum.empresa.dao;

import org.junit.Test;

public class AddCardOnAnIterationStory extends DefaultStory {

	@Test
	public void addACardInAnIteration() {
		given.thereIsAnUserNamed("sergio").and()
			.thereIsAProjectNamed("IEs4Linux")
				.ownedBy("sergio")
				.withACardNamed("support IE8")
					.planningCard()
					.whichDescriptionIs("IE8 must be supported").and()
				.withAnIterationWhichGoalIs("new release").and()
			.iAmLoggedInAs("sergio");
		when.iOpenProjectPageOf("IEs4Linux").and()
			.iOpenThePageOfIterationWithGoal("new release").and()
			.iAddTheCard("support IE8").inThisIteration();
		then.theCard("support IE8").appearsOnList("iteration_cards");
	}


	@Test
	public void promiscuousCardsBugDontHappen() {
		given.thereIsAnUserNamed("sergio").and()
			.thereIsAProjectNamed("IEs4Linux")
				.ownedBy("sergio")
				.withAnIterationWhichGoalIs("new release").and()
				.withACardNamed("support IE8")
					.whichDescriptionIs("IE8 must be supported")
					.planningCard().and()
			.thereIsAProjectNamed("Tatanka")
				.ownedBy("sergio")
				.withAnIterationWhichGoalIs("get promiscuous").and()
				.withACardNamed("I am promiscuous")
					.whichDescriptionIs("You know what it means")
					.planningCard().and()
			.iAmLoggedInAs("sergio");
		when.iOpenProjectPageOf("IEs4Linux").and()
		    .iOpenIterationsPage().and()
			.iOpenThePageOfIterationWithGoal("new release");
		then.theCard("support IE8").appearsOnBacklog().and()
			.theCard("I am promiscuous").notAppearsOnBacklog();
		when.iOpenProjectPageOf("Tatanka").and()
		    .iOpenIterationsPage().and()
			.iOpenThePageOfIterationWithGoal("get promiscuous");
		then.theCard("support IE8").notAppearsOnBacklog().and()
			.theCard("I am promiscuous").appearsOnBacklog();
	}
}