package br.com.uri.scopa.views;

import br.com.uri.scopa.controllers.PointsController;
import br.com.uri.scopa.models.Player;
import br.com.uri.scopa.models.ScoreHistory;

public class GameEndView {
	
	private PointsController pointsController = new PointsController();

	public void init(Player player1, Player player2) {
		this.pointsController.finalPointsHandler(player1, player2);
		this.endHandler(player1, player2);
	}
	
	private void endHandler(Player player1, Player player2) {
		ScoreHistory scorePlayer1 = player1.getScoreHistory();
		ScoreHistory scorePlayer2 = player2.getScoreHistory();
		System.out.println("Jogador " + player1.getName() + ": " + player1.getPoints());
		System.out.println("Jogador " + player2.getName() + ": " + player2.getPoints());
		this.checkResults(player1, player2);
		this.checkHighestScores(player1, player2);
		scorePlayer1.updateHistoryArchive(player1.getName());
		scorePlayer2.updateHistoryArchive(player2.getName());
	}

	private void checkResults(Player player1, Player player2) {
		ScoreHistory scorePlayer1 = player1.getScoreHistory();
		ScoreHistory scorePlayer2 = player2.getScoreHistory();
		if(player1.getPoints() == player2.getPoints()) {
			scorePlayer1.setDraws(scorePlayer1.getDraws()+1);
			scorePlayer2.setDraws(scorePlayer2.getDraws()+1);
			System.out.println("Resultado: Empatou!");
		} else if(player1.getPoints() > player2.getPoints()) {
			scorePlayer1.setVictories(scorePlayer1.getVictories()+1);
			scorePlayer2.setLosses(scorePlayer2.getLosses()+1);
			System.out.println("Resultado: o jogador " + player1.getName() + " venceu!");
		} else {
			scorePlayer1.setLosses(scorePlayer1.getLosses()+1);
			scorePlayer2.setVictories(scorePlayer2.getVictories()+1);
			System.out.println("Resultado: o jogador " + player2.getName() + " venceu!");
		}
	}
	
	private void checkHighestScores(Player player1, Player player2) {
		ScoreHistory scorePlayer1 = player1.getScoreHistory();
		ScoreHistory scorePlayer2 = player2.getScoreHistory();
		if(player1.getPoints() > player1.getScoreHistory().getHighestPontuation()) {
			scorePlayer1.setHighestPontuation(player1.getPoints());
			System.out.println("Parabéns ao jogador " + player1.getName() + " por quebrar seu recorde");
		}

		if(player2.getPoints() > player2.getScoreHistory().getHighestPontuation()) {
			scorePlayer2.setHighestPontuation(player2.getPoints());
			System.out.println("Parabéns ao jogador " + player2.getName() + " por quebrar seu recorde");
		}
	}
}
