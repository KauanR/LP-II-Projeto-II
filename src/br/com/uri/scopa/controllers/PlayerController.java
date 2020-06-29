package br.com.uri.scopa.controllers;

import java.util.ArrayList;

import br.com.uri.scopa.models.Card;
import br.com.uri.scopa.models.Deck;
import br.com.uri.scopa.models.Player;
import br.com.uri.scopa.models.Table;

public class PlayerController extends Common {

	public void initPlayer(Player player, Deck deck) {
		this.setPlayerName(player);
		this.setPlayerPoints(player);
		this.setPlayerHand(player, deck);
	}
	
	private void setPlayerName(Player player) {
		player.setName(scanner.nextLine());
		while(this.isEmptyString(player.getName())) {
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

}