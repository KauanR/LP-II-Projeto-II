package br.com.uri.scopa.views;

import br.com.uri.scopa.controllers.DeckController;
import br.com.uri.scopa.controllers.PlayerController;
import br.com.uri.scopa.controllers.RoundController;
import br.com.uri.scopa.controllers.TableController;
import br.com.uri.scopa.models.Deck;
import br.com.uri.scopa.models.Player;
import br.com.uri.scopa.models.Table;

public class GameView {

	private Player player1 = new Player();
	private Player player2 = new Player();
	private Deck deck = new Deck();
	private Table table = new Table();
	private DeckController deckController = new DeckController();
	private PlayerController playerController = new PlayerController();
	private RoundController roundController = new RoundController();
	private TableController tableController = new TableController();
	
	public void init() {
		deckController.initDeck(deck);
		
		System.out.println("Digite o nome do jogador 1: ");
		playerController.initPlayer(player1, deck);
		
		System.out.println("Digite o nome do jogador 2: ");
		playerController.initPlayer(player2, deck);
		
		tableController.initTable(table, deck);

		this.gameStart();
	}

	public void gameStart() {
		int round = 1;
		while(!deckController.isEmpty(this.deck)) {
			System.out.println("- - - - - - - - Rodada " + round + " - - - - - - - -");
			this.roundController.playerMove(player1, table, deck);
			this.roundController.playerMove(player2, table, deck);
			round++;
		}
	}
	
}
