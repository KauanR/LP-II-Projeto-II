package br.com.uri.scopa.models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ScoreHistory {

	private int victories;
	private int losses;
	private int draws;
	private int numberOfGames;
	private int highestPontuation;
	
	
	public ScoreHistory() {
	}

	public ScoreHistory(int victories, int losses, int draws, int numberOfGames, int highestPontuation) {
		this.victories = victories;
		this.losses = losses;
		this.draws = draws;
		this.numberOfGames = numberOfGames;
		this.highestPontuation = highestPontuation;
	}
	
	public void updateHistoryArchive(String name) {
		File file = new File("src/br/com/uri/scopa/history/"+name.trim().toLowerCase()+".txt");
		BufferedWriter fileWriter;
		try {
			fileWriter = new BufferedWriter(new FileWriter(file));
			fileWriter.write("victories:"+this.victories);
			fileWriter.newLine();
			fileWriter.write("losses:"+this.losses);
			fileWriter.newLine();
			fileWriter.write("draws:"+this.draws);
			fileWriter.newLine();
			fileWriter.write("numberOfGames:"+this.numberOfGames);
			fileWriter.newLine();
			fileWriter.write("highestPontuation:"+this.highestPontuation);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public FileReader createHistoryArchive(String name) throws IOException {
		File file = new File("src/br/com/uri/scopa/history/"+name.trim().toLowerCase()+".txt");
		FileReader fileReader = null;
		if(!file.exists()) {
			try {
				fileReader = new FileReader(file);
			} catch (FileNotFoundException e) {
				try {
					file.createNewFile();
					fileReader = new FileReader(file);
					BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file));
					fileWriter.write("victories:0");
					fileWriter.newLine();
					fileWriter.write("losses:0");
					fileWriter.newLine();
					fileWriter.write("draws:0");
					fileWriter.newLine();
					fileWriter.write("numberOfGames:0");
					fileWriter.newLine();
					fileWriter.write("highestPontuation:0");
					fileWriter.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		fileReader = new FileReader(file);
		return fileReader;
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
