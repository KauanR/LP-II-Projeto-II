package br.com.uri.scopa.models;

public class Card {

	private String name;
	private int value;
	private String suit;
	
	public Card(String name, int value, String suit) {
		this.name = name;
		this.value = value;
		this.suit = suit;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	public void printCard(int index) {
		System.out.println("Carta " + index + ": " + this.name + " de " + this.suit + "(valor: " + this.value + ")");
	}
	
	public void printCard() {
		System.out.println(this.name + " de " + this.suit);
	}
}
