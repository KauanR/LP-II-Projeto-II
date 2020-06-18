package br.com.uri.scopa.models;

import java.util.ArrayList;

public class Game {

	private ArrayList<Player> players = new ArrayList<Player>();
	private Deck table;
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public Deck getTable() {
		return table;
	}
	
	public void setTable(Deck table) {
		this.table = table;
	}

}
