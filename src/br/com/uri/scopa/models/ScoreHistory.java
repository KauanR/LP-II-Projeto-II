package br.com.uri.scopa.models;

public class ScoreHistory {

	private int victories;
	private int losses;
	private int draws;
	private int numberOfGames;
	private int highestPontuation;
	
	public ScoreHistory(int victories, int losses, int draws, int numberOfGames, int highestPontuation) {
		this.victories = victories;
		this.losses = losses;
		this.draws = draws;
		this.numberOfGames = numberOfGames;
		this.highestPontuation = highestPontuation;
	}

	public int getVictories() {
		return victories;
	}
	
	public void setVictories(int victories) {
		this.victories = victories;
	}
	
	public int getLosses() {
		return losses;
	}
	
	public void setLosses(int losses) {
		this.losses = losses;
	}
	
	public int getDraws() {
		return draws;
	}
	
	public void setDraws(int draws) {
		this.draws = draws;
	}
	
	public int getNumberOfGames() {
		return numberOfGames;
	}
	
	public void setNumberOfGames(int numberOfGames) {
		this.numberOfGames = numberOfGames;
	}
	
	public int getHighestPontuation() {
		return highestPontuation;
	}
	
	public void setHighestPontuation(int highestPontuation) {
		this.highestPontuation = highestPontuation;
	}
}
