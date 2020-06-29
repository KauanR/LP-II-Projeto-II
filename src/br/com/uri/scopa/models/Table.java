package br.com.uri.scopa.models;

import java.util.ArrayList;

public class Table {
	
	private ArrayList<Card> cards = new ArrayList<Card>();

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	public void addCard(Card card) {
		this.cards.add(card);
	}
	
	public void removeCard(Card card) {
		this.cards.remove(card);
	}
	
	public void removeCard(ArrayList<Card> cards) {
		this.cards.removeAll(cards);
	}

	public void printTable() {
		System.out.println("Mesa: ");
		for(Card card : this.cards) {
			card.printCard(this.cards.indexOf(card) + 1);
		}
	}
}
