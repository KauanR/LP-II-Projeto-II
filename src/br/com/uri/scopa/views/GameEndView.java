package br.com.uri.scopa.views;

import br.com.uri.scopa.controllers.PointsController;
import br.com.uri.scopa.models.Player;

public class GameEndView {
	
	private PointsController pointsController = new PointsController();

	public boolean init(Player player1, Player player2) {
		this.pointsController.finalPointsHandler(player1, player2);
		this.endHandler(player1, player2);
		return true;
	}
	
	private void endHandler(Player player1, Player player2) {
		this.checkResults(player1, player2);
		this.checkHighestScores(player1, player2);
	}

	private void checkResults(Player player1, Player player2) {
		// player1.txt numberOfGames++
		// player2.txt numberOfGames++
		if(player1.getPoints() == player2.getPoints()) {
			// player1.txt draws++
			// player2.txt draws++
			// sysout empatou blablabla
		} else if(player1.getPoints() > player2.getPoints()) {
			// player1.txt wins++
			// player2.txt looses++
			// sysout player1 ganhou blablabla
		} else {
			// player1.txt looses++
			// player2.txt wins++
			// sysout player2 ganhou blablabla
		}
	}
	
	private void checkHighestScores(Player player1, Player player2) {
		if(player1.getPoints() > player1.getScoreHistory().getHighestPontuation()) {
			// player1.txt highestPontuation
			// sysout player1 quebrou recorde blablabla
		}
		
		if(player2.getPoints() > player2.getScoreHistory().getHighestPontuation()) {
			// player2.txt highestPontuation
			// sysout player2 quebrou recorde blablabla	
		}
	}
}
