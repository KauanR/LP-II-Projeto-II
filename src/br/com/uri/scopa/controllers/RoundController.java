package br.com.uri.scopa.controllers;

import java.util.ArrayList;

import br.com.uri.scopa.models.Card;
import br.com.uri.scopa.models.Deck;
import br.com.uri.scopa.models.Player;
import br.com.uri.scopa.models.Table;

public class RoundController extends Common {
	
	public void playerMove(Player player, Table table, Deck deck) {
		player.printPlayer();
		System.out.println("---------------------------");
		System.out.println("Cartas da Mesa:");
		this.printCardArray(table.getCards());
		System.out.println("Cartas do Jogador:");
		this.printCardArray(player.getHand());
		System.out.println("---------------------------");
		
		ArrayList<Card> choosedCards = new ArrayList<Card>();
		boolean move = true;
		while(move) {
			System.out.println("Quais cartas você irá juntar da sua mão?");
			Card handCard = this.pickCard(player.getHand());
			scanner.nextLine();
			if(this.checkDiscard().equals("D")) {
				player.removeCard(handCard);
				table.addCard(handCard);
				move = false;
				break;
			}
			choosedCards.add(handCard);
			
			System.out.println("E quais da mesa?");
			choosedCards.addAll(pickTableCards(table.getCards()));
			
			move = this.checkMove(player, table, choosedCards);
		}
		this.checkEmptyHand(player, table, deck);
	}

	private Card pickCard(ArrayList<Card> cards) {
		this.printCardArray(cards);
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
		ArrayList<Card> tableCards = new ArrayList<Card>();
		boolean aux = true;
		while(aux) {
			Card tableCard = this.pickCard(cards);
			tableCards.add(tableCard);
			System.out.println("Adicionar outra?(s/n)");
			aux = scanner.next().toLowerCase().equals("s");
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

	private void clearSelectedCards(Player player, Table table, ArrayList<Card> cards) {
		player.removeCard(cards.get(0));
		cards.remove(0);
		table.removeCard(cards);
	}
	
	private void checkEmptyHand(Player player, Table table, Deck deck) {
		if(player.getHand().isEmpty()) {
			ArrayList<Card> newHandCards = new ArrayList<Card>();
			for(int i = 0; i < 3; i++) {
				Card aux = deck.getCards().get(i);
				newHandCards.add(aux);
				deck.removeCard(aux);
			}
			player.setHand(newHandCards);
		}
	}
}
