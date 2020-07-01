package br.com.uri.scopa.controllers;

import java.util.ArrayList;

import br.com.uri.scopa.models.Card;
import br.com.uri.scopa.models.Deck;
import br.com.uri.scopa.models.Player;

public class PlayerController extends Common {

	public void initPlayer(Player player, Deck deck) {
		this.setPlayerName(player);
		this.setPlayerPoints(player);
		this.setPlayerHand(player, deck);
	}
	
	private void setPlayerName(Player player) {
		player.setName(scanner.nextLine());
		while(player.getName().equals("")) {
			this.invalidValuePrint();
			player.setName(scanner.nextLine());
		}
	}
	
	private void setPlayerPoints(Player player) {
		player.setPoints(0);
	}
	
	private void setPlayerHand(Player player, Deck deck) {
		ArrayList<Card> hand = new ArrayList<Card>() {{
			add(deck.getCards().get(0));
			add(deck.getCards().get(1));
			add(deck.getCards().get(2));
		}};
		player.setHand(hand);
		deck.getCards().removeIf(card -> hand.contains(card));
	}
	
	public void checkEmptyHand(Player player, Deck deck) {
		if(player.getHand().isEmpty()) {
			ArrayList<Card> newHandCards = new ArrayList<Card>();
			for(int i = 0; i < 3; i++) {
				Card aux = deck.getCards().get(i);
				newHandCards.add(aux);
				deck.removeCard(aux);
			}
			player.setHand(newHandCards);
		}
	}
	
	public void addScoreCards(Player player, ArrayList<Card> moveCards) {
		
	}

}