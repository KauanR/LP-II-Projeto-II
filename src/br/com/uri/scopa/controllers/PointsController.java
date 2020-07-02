package br.com.uri.scopa.controllers;

import java.util.ArrayList;

import br.com.uri.scopa.models.Card;
import br.com.uri.scopa.models.Player;
import br.com.uri.scopa.models.Table;

public class PointsController {

	public void finalPointsHandler(Player player1, Player player2) {
		ArrayList<Player> players = new ArrayList<Player>() {{
			add(player1);
			add(player2);
		}};
		
		for(Player player : players) {
			this.checkSevenGold(player);
			this.checkMostOfSevens(player);
		};
		this.checkMostGolds(player1, player2);
		this.checkMostCards(player1, player2);
	}
	
	private void addScoreCards(Player player, ArrayList<Card> moveCards, int points) {
		player.addScoreCards(moveCards);
		player.increasePoints(points);
	}
	
	
	public void checkScopa(Player player, ArrayList<Card> moveCards, Table table) {
		if(table.getCards().isEmpty())
			this.addScoreCards(player, moveCards, 1);
		else
			this.addScoreCards(player, moveCards, 0);
	}
	
	
	private void checkMostGolds(Player player1, Player player2) {
		ArrayList<Card> p1Backup = new ArrayList<Card>() {{
			addAll(player1.getScoreCards());
		}};
		ArrayList<Card> p2Backup = new ArrayList<Card>() {{
			addAll(player2.getScoreCards());
		}};
		
		p1Backup.removeIf(el -> !el.getSuit().equals("Ouros"));
		p2Backup.removeIf(el -> !el.getSuit().equals("Ouros"));
		
		if(p1Backup.size() > p2Backup.size()) {
			player1.increasePoints(1);
		} else {
			player2.increasePoints(1);
		}
	}

	private void checkMostCards(Player player1, Player player2) {
		if(player1.getScoreCards().size() > player2.getScoreCards().size()) {
			player1.increasePoints(1);
		} else {
			player2.increasePoints(2);
		}
	}
	
	private void checkMostOfSevens(Player player) {
		int sevens = 0;
		for(Card card : player.getScoreCards()) {
			if(card.getValue() == 7)
				sevens++;
		}
		if(sevens == 4)
			player.increasePoints(3);
	}

	private void checkSevenGold(Player player) {
		Card sevenGold = new Card("Sete", 7, "Ouros");
		if(player.getScoreCards().contains(sevenGold))
			player.increasePoints(1);
	}

}
