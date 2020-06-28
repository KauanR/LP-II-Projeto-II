package br.com.uri.scopa.views;

import br.com.uri.scopa.controllers.DeckController;
import br.com.uri.scopa.controllers.PlayerController;
import br.com.uri.scopa.controllers.TableController;
import br.com.uri.scopa.models.Deck;
import br.com.uri.scopa.models.Player;
import br.com.uri.scopa.models.Table;

public class GameView {

	private Player player1 = new Player();
	private Player player2 = new Player();
	private Deck deck = new Deck();
	private Table table = new Table();
	DeckController deckController = new DeckController();
	PlayerController playerController = new PlayerController();
	TableController tableController = new TableController();
	
	public void init() {
		deckController.initDeck(deck);
		System.out.println("Digite o nome do jogador 1: ");
		playerController.initPlayer(player1, deck);
		System.out.println("Digite o nome do jogador 2: ");
		playerController.initPlayer(player2, deck);
		tableController.initTable(deck, table);
	}
	
	public void showTable() {
		// TODO fazer ainda né
	}
}
