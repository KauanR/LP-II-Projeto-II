package br.com.uri.scopa.controllers;

import java.util.ArrayList;
import java.util.Collections;

import br.com.uri.scopa.models.Card;
import br.com.uri.scopa.models.Deck;

public class DeckController {
	
	private final ArrayList<String> suits = new ArrayList<String>() {{
		add("Espadas");
		add("Paus");
		add("Copas");
		add("Ouros");
	}};
	
	private final ArrayList<String> names = new ArrayList<String>() {{
		add("Ás");
		add("2");
		add("3");
		add("4");
		add("5");
		add("6");
		add("7");
		add("Valete");
		add("Rainha");
		add("Rei");
	}};

	public void initDeck(Deck deck) {
		ArrayList<Card> cards = new ArrayList<Card>();
		
		int valueAux = 0;
		for(String name : names) {
			valueAux++;
			for(String suit : suits) {
				cards.add(new Card(name, valueAux, suit));
			}
		}
		
		Collections.shuffle(cards);
		deck.setCards(cards);
	}
}
