package game_logic;

import java.util.ArrayList;
import java.util.HashMap;

import card.Card;
import game_control.Players;
import player.Deck;
import player.Player;

public class GameLogic {
	String configPath = Card.getConfigpath();
	HashMap<Players, Player> players = new HashMap<Players, Player>();
	ArrayList<Card> selfField = new ArrayList<Card>();
	ArrayList<Card> enemyField = new ArrayList<Card>();
	
	public GameLogic(Player self, Player enemy) {
		players.put(Players.SELF, self);
		players.put(Players.ENEMY, enemy);
		
	}
	
	public ArrayList<Player> getPlayers() {
		return new ArrayList<Player>(players.values());
	}
	
	public HashMap<String, Integer> getPlayerStats(Players p) {
		return players.get(p).stats();
	}
}
