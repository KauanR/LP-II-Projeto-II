package br.com.uri.scopa.controllers;

import java.util.ArrayList;

import br.com.uri.scopa.models.Card;
import br.com.uri.scopa.models.Player;
import br.com.uri.scopa.models.Table;

public class PointsController {

	public void finalPointsHandler(ArrayList<Player> players) {		
		for(Player player : players) {
			this.verifySevenGold(player);
			this.verifyMostOfSevens(player);
		};
		this.verifyMostGold(players);
	}
	
	private void verifyMostGold(ArrayList<Player> players) {
		
		for(Player player : players) {
			
		}
	}

	private void verifyMostOfSevens(Player player) {
		int sevens = 0;
		for(Card card : player.getScoreCards()) {
			if(card.getValue() == 7)
				sevens++;
		}
		if(sevens == 4)
			player.increasePoints(3);
	}

	public void checkScopa(Player player, ArrayList<Card> moveCards, Table table) {
		if(table.getCards().isEmpty())
			this.addScoreCards(player, moveCards, 1);
		else
			this.addScoreCards(player, moveCards, 0);
	}

	private void verifySevenGold(Player player) {
		Card sevenGold = new Card("Sete", 7, "Ouros");
		if(player.getScoreCards().contains(sevenGold))
			player.increasePoints(1);
	}

	private void addScoreCards(Player player, ArrayList<Card> moveCards, int points) {
		player.addScoreCards(moveCards);
		player.increasePoints(points);
	}
}
