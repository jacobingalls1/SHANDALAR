package game_display;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EtchedBorder;

import card.Card;
import card.SmallPanel;
import game_control.Players;
import player.Player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

public class GameDisplay extends JPanel {
	HandTable handTable = new HandTable();
	HashMap<Players, Player> players = new HashMap<Players, Player>(); 
	HashMap<Players, Tableau> tableaus = new HashMap<Players, Tableau>();
	HashMap<Players, PersonPanel> personPanels = new HashMap<Players, PersonPanel>();
	CardFocus cardFocus;
	JPanel left;
	JPanel right;
	JSplitPane all;
	
	
	public GameDisplay(Player self, Player enemy) {
		super();
		setBackground(Color.red);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		left = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		
		right = new JPanel();
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		
		left.setMinimumSize(new Dimension(320, 800));
		right.setMinimumSize(new Dimension(800, 800));
		
		left.setBorder(new EtchedBorder());
		right.setBorder(new EtchedBorder());

		players.put(Players.SELF, self);
		players.put(Players.ENEMY, enemy);
		
		tableaus.put(Players.SELF, new Tableau());
		tableaus.put(Players.ENEMY, new Tableau());
		
		personPanels.put(Players.SELF, new PersonPanel(self.getPortrait(), 0, 0, 0, 0, self.getName()));
		personPanels.put(Players.ENEMY, new PersonPanel(enemy.getPortrait(), 0, 0, 0, 0, enemy.getName()));
		
		cardFocus = new CardFocus();
		
		left.add(personPanels.get(Players.ENEMY));
		left.add(cardFocus);
		left.add(personPanels.get(Players.SELF));
		
		right.add(tableaus.get(Players.ENEMY));
		right.add(tableaus.get(Players.SELF));
		right.add(handTable);
				
		all = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, right);
		
		add(all);
		
	}
	
	public void updateHand(ArrayList<Card> hand, MouseListener m) {
		handTable.update(hand, m);
		handTable.repaint();
	}
	
	public void focusCard(Card c) {
		cardFocus.update(c);		
	}
	
	public void playCard(SmallPanel c, Players p) {
		tableaus.get(p).addCard(c);
	}
	
	public void updatePersonal() {
		personPanels.get(Players.SELF).update(players.get(Players.SELF).stats());
		personPanels.get(Players.ENEMY).update(players.get(Players.ENEMY).stats());
	}
	
	public void doFocus() {
		for (SmallPanel sp : handTable.getCards()) {
			if (sp.getFocus()) {
				focusCard(sp.getCard());
			}
		}
	}
}
