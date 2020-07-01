package br.com.uri.scopa.controllers;

import java.util.ArrayList;

import br.com.uri.scopa.models.Card;
import br.com.uri.scopa.models.Deck;
import br.com.uri.scopa.models.Player;
import br.com.uri.scopa.models.Table;

public class RoundController extends Common {
	
	public void playerMove(Player player, Table table, Deck deck) {
		player.printPlayer();
		System.out.println("CARTAS DA MESA:");
		this.printCardArray(table.getCards(), false);
		System.out.println("CARTAS DO JOGADOR:");
		this.printCardArray(player.getHand(), false);
		System.out.println("---------------------------");
		
		boolean move = true;
		while(move) {
			ArrayList<Card> moveCards = new ArrayList<Card>();
			System.out.println("Quais cartas você irá juntar da sua mão?");
			Card handCard = this.pickCard(player.getHand());
			scanner.nextLine();
			if(this.checkDiscard().equals("D")) {
				player.removeCard(handCard);
				table.addCard(handCard);
				move = false;
				break;
			}
			moveCards.add(handCard);
			
			System.out.println("E quais da mesa?");
			moveCards.addAll(pickTableCards(table.getCards()));
			
			move = this.checkMove(player, table, moveCards);
		}
	}

	private Card pickCard(ArrayList<Card> cards) {
		this.printCardArray(cards, true);
		int aux = scanner.nextInt();
		if(aux < 0 && aux >= cards.size()) {
			this.invalidValuePrint();
			return this.pickCard(cards);
		}
		return cards.get(aux - 1);
	}
	
	private String checkDiscard() {
		System.out.println("É para descartar ou fazer uma jogada?(D = descartar | J = jogada)");
		String aux = scanner.next().toUpperCase();

		if(aux.equals("D") && aux.equals("J")) {
			this.invalidValuePrint();
			return this.checkDiscard();
		}
		return aux;
	}
	
	private ArrayList<Card> pickTableCards(ArrayList<Card> cards)  {
		ArrayList<Card> cardsBackup = new ArrayList<Card>() {{
			addAll(cards);
		}};
		ArrayList<Card> selectedCards = new ArrayList<Card>();
		boolean aux = true;
		while(aux) {
			Card selectedCard = this.pickCard(cardsBackup);
			selectedCards.add(selectedCard);
			cardsBackup.remove(selectedCard);
			System.out.println("Adicionar outra?(s/n)");
			aux = scanner.next().toLowerCase().equals("s");
		}
		return selectedCards;
	}
	
	private boolean checkMove(Player player, Table table, ArrayList<Card> cards) {
		int total = 0;
		for(Card el : cards) {
			total += el.getValue();
		}
		boolean validMove = total == 15;
		if(validMove) {
			this.moveEnd(player, table, cards);
		} else {
			System.out.println("Sua jogada não fechou os 15 pontos, por favor, tente novamente.");
		}
		return !validMove;
	}

	private void moveEnd(Player player, Table table, ArrayList<Card> moveCards) {
		player.removeCard(moveCards.get(0));
		moveCards.remove(0);
		table.removeCard(moveCards);
	}
	
	
}
