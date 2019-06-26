package game_control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import card.Card;
import card.SmallPanel;
import game_display.GameDisplay;
import game_logic.GameLogic;
import player.Deck;
import player.Player;

public class Game implements MouseListener {
	GameLogic gameLogic;
	GameDisplay gameDisplay;
	ArrayList<SmallPanel> smallPanels = new ArrayList<SmallPanel>();
	Player self, enemy;
	
	public Game(String selfName, String enemyName) {
		self = new Player(new Deck(selfName), selfName);
		enemy = new Player(new Deck(enemyName), enemyName);
		gameLogic = new GameLogic(self, enemy);
		gameDisplay = new GameDisplay(self, enemy);
		
	}
	
	private void addToTableau(Card c, Players p) {
		SmallPanel sp = c.getSmallPanel();
		sp.addMouseListener(this);
	}
	
	public void doTest() {
		System.out.println("here");
		self.doStandardStart();
		enemy.doStandardStart();
		self.draw(7);
		gameDisplay.updatePersonal();
		gameDisplay.updateHand(self.getHand(), this);
		gameDisplay.focusCard(self.getHand().get(0));
		gameDisplay.focusCard(self.getHand().get(1));
		for (Card c : self.getHand()) {
			addToTableau(c, Players.ENEMY);
			for (Card h : self.getHand()) {
				addToTableau(c, Players.SELF);
			}
		}
//		gd.playCard(test1.getHand().get(0), Players.SELF);
		addToTableau(self.getHand().get(1), Players.ENEMY);
		
	}
	
	public GameDisplay getDisplay() {
		return gameDisplay;
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("ENTER");
		gameDisplay.doFocus();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
