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
	
	public void playerMove(Player player, Table table) {
		player.printPlayer();
		table.printTable();
		
		ArrayList<Card> choosedCards = new ArrayList<Card>();
		boolean move = true;
		while(move) {
			System.out.println("Quais cartas você irá juntar da sua mão?");
			Card handCard = this.pickCard(player.getHand());
			if(this.checkDiscard() == "D") {
				player.removeCard(handCard);
				table.addCard(handCard);
				move = false;
			}
			choosedCards.add(handCard);
			
			System.out.println("E quais da mesa?");
			choosedCards.addAll(pickTableCards(table.getCards()));
			
			move = this.checkMove(player, table, choosedCards);
		}
	}

	private Card pickCard(ArrayList<Card> cards) {
		int aux = scanner.nextInt();
		if(aux > 0 && aux < cards.size() - 1) {
			this.invalidValuePrint();
			return this.pickCard(cards);
		}
		return cards.get(scanner.nextInt() - 1);
	}
	
	private String checkDiscard() {
		System.out.println("É para descartar ou fazer uma jogada?(D = descartar | J = jogada)");
		String aux = scanner.next();
		if(aux != "D" && aux != "J") {
			this.invalidValuePrint();
			return this.checkDiscard();
		}
		return aux;
	}
	
	private ArrayList<Card> pickTableCards(ArrayList<Card> cards)  {
		ArrayList<Card> tableCards = new ArrayList<Card>();
		boolean aux = true;
		while(aux) {
			Card tableCard = this.pickCard(cards);
			tableCards.add(tableCard);
			System.out.println("Adicionar outra?(s/n)");
			aux = scanner.next().toLowerCase() == "s";
		}
		return tableCards;
	}
	
	private boolean checkMove(Player player, Table table, ArrayList<Card> cards) {
		int total = 0;
		for(Card el : cards) {
			total += el.getValue();
		}
		this.clearSelectedCards(player, table, cards);
		return total != 15;
	}
	
}
	private void clearSelectedCards(Player player, Table table, ArrayList<Card> cards) {
		player.removeCard(cards.get(0));
		cards.remove(0);
		table.removeCard(cards);
	}
}