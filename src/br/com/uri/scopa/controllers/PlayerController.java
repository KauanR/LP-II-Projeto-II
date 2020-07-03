package br.com.uri.scopa.controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import br.com.uri.scopa.models.Card;
import br.com.uri.scopa.models.Deck;
import br.com.uri.scopa.models.Player;
import br.com.uri.scopa.models.ScoreHistory;

public class PlayerController extends Common {
	
	public void initPlayer(Player player, Deck deck) throws IOException  {
		this.setPlayerName(player);
		this.setPlayerPoints(player);
		this.setPlayerHand(player, deck);
		this.setPlayerScoreHistory(player);
	}
	
	private void setPlayerName(Player player) {
		player.setName(scanner.nextLine());
		while(player.getName().equals("")) {
			this.invalidValuePrint();
			player.setName(scanner.next());
		}
	}
	
	private void setPlayerPoints(Player player) {
		player.setPoints(0);
	}
	
	private void setPlayerScoreHistory(Player player) throws IOException {
		player.setScoreHistory(new ScoreHistory());
		BufferedReader playerFileR = new BufferedReader(player.getScoreHistory().createHistoryArchive(player.getName()));
		int scores[] = {0, 0, 0, 0, 0};
		int currentLine = 0;
		String line;
		
		while((line = playerFileR.readLine()) != null) {
			int index = line.indexOf(":") + 1;
			scores[currentLine] = Integer.parseInt(line.substring(index));
			currentLine++;
		}
		player.setScoreHistory(new ScoreHistory(scores[0], scores[1], scores[2], scores[3], scores[4]));
		
		playerFileR.close();
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
	
	public void checkEmptyHand(Player player, Deck deck) {
		if(player.getHand().isEmpty() && !deck.getCards().isEmpty()) {
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