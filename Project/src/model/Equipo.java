package model;

public class Equipo {

	private Player[] players;
	
	public Equipo() {
		players = new Player[20];
		for(int i = 0; i < players.length ; i ++) {
			players[i] = new Player("Jugador" + i, i + 1);
		}
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}	
	
}
