package br.com.uri.scopa.controllers;

import java.util.ArrayList;

import br.com.uri.scopa.models.Card;
import br.com.uri.scopa.models.Player;
import br.com.uri.scopa.models.Table;

public class RoundController extends Common {
	
	public ArrayList<Card> playerMove(Player player, Table table, int roundNumber, int deckSize) {
		System.out.println("- - - - - - - - - Rodada " + roundNumber + "(Jogador: " + player.getName() + ") - - - - - - - - -");
		System.out.println("CARTAS RESTANTES DO BARALHO: " + deckSize);
		System.out.println("CARTAS DA MESA:");
		this.printCardArray(table.getCards(), false);
		System.out.println("- - - - - - - - - - - - - - - - - -");
		
		boolean move = true;
		ArrayList<Card> moveCards = new ArrayList<Card>();
		
		while(move) {
			moveCards.clear();
			
			if(table.getCards().isEmpty()) System.out.println("Qual carta voc� quer descartar?");
			else System.out.println("Quais cartas voc� ir� juntar da sua m�o?");
			
			Card handCard = this.pickCard(player.getHand());
			scanner.nextLine();
			if(this.checkDiscard().equals("D") || table.getCards().isEmpty()) {
				player.removeHandCard(handCard);
				table.addCard(handCard);
				move = false;
				break;
			}
			moveCards.add(handCard);
			
			System.out.println("E quais da mesa?");
			moveCards.addAll(pickTableCards(table.getCards(), handCard));
			
			move = this.checkMove(player, table, moveCards);
		}
		return moveCards;
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
		System.out.println("� para descartar ou fazer uma jogada?(D = descartar | J = jogada)");
		String aux = scanner.next().toUpperCase();

		if(aux.equals("D") && aux.equals("J")) {
			this.invalidValuePrint();
			return this.checkDiscard();
		}
		return aux;
	}
	
	private ArrayList<Card> pickTableCards(ArrayList<Card> cards, Card handCard)  {
		ArrayList<Card> cardsBackup = new ArrayList<Card>() {{
			addAll(cards);
		}};
		ArrayList<Card> selectedCards = new ArrayList<Card>();
		boolean aux = true;
		int movePoints = handCard.getValue();
		while(aux) {
			Card selectedCard = this.pickCard(cardsBackup);
			movePoints+=selectedCard.getValue();
			selectedCards.add(selectedCard);
			cardsBackup.remove(selectedCard);
			System.out.println("Soma feita at� agora: " + movePoints);
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
			this.roundEnd(player, table, cards);
		} else {
			System.out.println("Sua jogada n�o fechou os 15 pontos, por favor, tente novamente.");
		}
		return !validMove;
	}

	private void roundEnd(Player player, Table table, ArrayList<Card> moveCards) {
		player.removeHandCard(moveCards.get(0));
		moveCards.remove(0);
		table.removeCard(moveCards);
	}
	
}
