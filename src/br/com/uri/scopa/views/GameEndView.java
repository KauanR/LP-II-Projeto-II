package br.com.uri.scopa.views;

import br.com.uri.scopa.controllers.PointsController;
import br.com.uri.scopa.models.Player;

public class GameEndView {
	
	private PointsController pointsController = new PointsController();

	public boolean init(Player player1, Player player2) {
		this.pointsController.finalPointsHandler(player1, player2);
		return true;
	}
}
