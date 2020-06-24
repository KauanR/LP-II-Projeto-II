package br.com.uri.scopa.controllers;

import br.com.uri.scopa.models.Player;

public class PlayerController extends Common {

	public void initPlayer(Player player) {
		this.setPlayerName(player);
		this.setPlayerPoints(player);
		this.setPlayerHand(player);
	}
	
	private void setPlayerName(Player player) {
		System.out.println("Digite o nome do jogador:");
		player.setName(scanner.nextLine());
		while(this.isEmptyString(player.getName())) {
			this.invalidValuePrint();
			player.setName(scanner.nextLine());
		}
	}
	
	private void setPlayerPoints(Player player) {
		player.setPoints(0);
	}
	
	private void setPlayerHand(Player player) {
		// CHAMAR O CONTROLER DO DECK BONITÃO
	}
}
