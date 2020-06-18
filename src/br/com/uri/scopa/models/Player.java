package br.com.uri.scopa.models;

public class Player {

	private int points;
	private Deck hand;
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}

	public Deck getHand() {
		return hand;
	}

	public void setHand(Deck hand) {
		this.hand = hand;
	}
	
}
