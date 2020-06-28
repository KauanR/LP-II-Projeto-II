package br.com.uri.scopa.models;

import java.util.ArrayList;

public class Player {

	private String name;
	private int points;
	private ArrayList<Card> hand = new ArrayList<Card>();
	
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
	
}
