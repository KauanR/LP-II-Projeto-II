package br.com.uri.scopa.controllers;

import java.util.ArrayList;

import br.com.uri.scopa.models.Card;
import br.com.uri.scopa.models.Deck;
import br.com.uri.scopa.models.Table;

public class TableController {

	public void initTable(Table table, Deck deck) {
		ArrayList<Card> hand = new ArrayList<Card>() {{
			add(deck.getCards().get(0));
			add(deck.getCards().get(1));
			add(deck.getCards().get(2));
			add(deck.getCards().get(3));
		}};
		table.setCards(hand);
		deck.getCards().removeIf(card -> hand.contains(card));
	}

}
