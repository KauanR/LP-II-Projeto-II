package br.com.uri.scopa.models;

import java.util.ArrayList;

public class Player {

	private String name;
	private int points;
	private ArrayList<Card> hand = new ArrayList<Card>();
	private ArrayList<Card> scoreCards = new ArrayList<Card>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	
	public void addHandCard(Card card) {
		this.hand.add(card);
	}
	
	public void removeHandCard(Card card) {
		this.hand.remove(card);
	}
	
	public ArrayList<Card> getScoreCards() {
		return scoreCards;
	}

	public void setScoreCards(ArrayList<Card> scoreCards) {
		this.scoreCards = scoreCards;
	}
	
	public void addScoreCards(ArrayList<Card> scoreCards) {
		this.scoreCards.addAll(scoreCards);
	}

	public void printPlayer() {
		System.out.println("JOGADOR " + this.name + ":");
	}
}
