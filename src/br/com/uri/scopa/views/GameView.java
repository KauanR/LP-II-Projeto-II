package br.com.uri.scopa.views;

import java.util.ArrayList;

import br.com.uri.scopa.controllers.DeckController;
import br.com.uri.scopa.controllers.PlayerController;
import br.com.uri.scopa.controllers.PointsController;
import br.com.uri.scopa.controllers.RoundController;
import br.com.uri.scopa.controllers.TableController;
import br.com.uri.scopa.models.Card;
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
	private PointsController pointsController = new PointsController();
	
	private GameEndView gameEndView = new GameEndView();
	
	public void init() {
		boolean playAgain = true;
		while(playAgain) {			
			deckController.initDeck(deck);
			
			System.out.println("Digite o nome do Jogador 1: ");
			playerController.initPlayer(player1, "player1", deck);
			
			System.out.println("Digite o nome do Jogador 2: ");
			playerController.initPlayer(player2, "player2", deck);
			
			tableController.initTable(table, deck);
			
			this.gameStart();

			playAgain = gameEndView.init(player1, player2);
		}
	}

	private void gameStart() {
		int roundNumber = 1;
		while(!deckController.isEmpty(this.deck)) {
			this.playerMoveHandler(player1, roundNumber);
			this.playerMoveHandler(player2, roundNumber);
			roundNumber++;
		}
	}
	
	private void playerMoveHandler(Player player, int roundNumber) {
		ArrayList<Card> moveCards = new ArrayList<Card>();
		moveCards.addAll(this.roundController.playerMove(player, this.table, roundNumber));
		this.playerController.checkEmptyHand(player, this.deck);
		this.pointsController.checkScopa(player, moveCards, this.table);
	}
}
