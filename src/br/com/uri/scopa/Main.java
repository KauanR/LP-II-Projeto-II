package br.com.uri.scopa;

import br.com.uri.scopa.controllers.DeckController;
import br.com.uri.scopa.controllers.PlayerController;
import br.com.uri.scopa.models.Deck;
import br.com.uri.scopa.models.Player;

public class Main {
	
	public static void main(String[] args) {
		
		DeckController controlinho = new DeckController();
		Deck deckinho = new Deck();
		
		controlinho.initDeck(deckinho);
	}
}
