package main;

import javax.swing.JFrame;

import card.Card;
import game_control.Game;
import game_control.Players;
import game_display.GameDisplay;
import player.Deck;
import player.Player;

public class Main {
	Game game;
	public Main(Game g) {
		game = g;
	}
	
	public Game getGame() {
		return game;
	}


	public static void main(String[] args) {
		JFrame jf = new JFrame("Game");
		jf.setSize(1200, 890);
		Main m = new Main(new Game("test1", "test2"));
		jf.add(m.getGame().getDisplay());
		m.getGame().doTest();
		jf.setVisible(true);
	}
}