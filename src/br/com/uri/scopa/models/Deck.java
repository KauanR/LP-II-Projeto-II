package br.com.uri.scopa.models;

import java.util.ArrayList;

public class Deck {

	private ArrayList<Card> cards = new ArrayList<Card>();

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	public void removeCard(Card card) {
		this.cards.remove(card);
	}
}
