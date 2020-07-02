package br.com.uri.scopa;

import java.io.File;
import java.io.IOException;

import br.com.uri.scopa.views.GameView;

public class Main {
	
	public static void main(String[] args) throws IOException {
		File teste = new File("src/br/com/uri/scopa/player1.txt");
		File teste2 = new File("src/br/com/uri/scopa/player3.txt");
		
		System.out.println(teste.exists());
		System.out.println(teste2.exists());
		GameView game = new GameView();
		game.init();
		
	}
	
}