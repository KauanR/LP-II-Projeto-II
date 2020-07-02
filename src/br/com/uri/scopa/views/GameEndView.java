package br.com.uri.scopa.views;

import java.util.ArrayList;

import br.com.uri.scopa.controllers.PointsController;
import br.com.uri.scopa.models.Player;

public class GameEndView {
	
	PointsController pointsController = new PointsController();

	public boolean init(Player player1, Player player2) {
		ArrayList<Player> players = new ArrayList<Player>() {{
			add(player1);
			add(player2);
		}};
		this.pointsController.finalPointsHandler(players);
		return true;
	}
}
