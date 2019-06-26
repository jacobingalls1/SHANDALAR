package game_display;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import card.Card;

public class PersonPanel extends JPanel {
	
	static String configPath = Card.getConfigpath();
	ImageIcon portrait;
	Integer lifeInt;
	Integer handInt;
	Integer deckInt;
	Integer graveyardInt;
	String nameStr;
	
	JLabel lifeLab;
	JLabel handLab;
	JLabel deckLab;
	JLabel graveyardLab;
	JLabel theRestLab;
	JLabel nameLab;
	
	JPanel life;
	JPanel hand;
	JPanel deck;
	JPanel graveyard;
	JPanel theRest;
	JPanel boundStats;
	JPanel name;
	
	public PersonPanel(ImageIcon portrait, int life, int hand, int deck, int graveyard, String name) {
		super();
		setMinimumSize(new Dimension(200, 200));
		setMaximumSize(new Dimension(200, 200));
		boundStats = new JPanel();
		boundStats.setMaximumSize(new Dimension(50, 200));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		boundStats.setLayout(new GridLayout(0,1));
		this.portrait = portrait;
		this.lifeInt = life;
		this.handInt = hand;
		this.deckInt = deck;
		this.graveyardInt = graveyard;
		this.nameStr = name;
		
		this.life = new JPanel();
		this.hand = new JPanel();
		this.deck = new JPanel();
		this.graveyard = new JPanel();
		this.name = new JPanel();
		
		this.lifeLab = new JLabel();
		this.handLab = new JLabel();
		this.deckLab = new JLabel();
		this.graveyardLab = new JLabel();
		this.nameLab = new JLabel();
		
		System.out.println("NEED TO ADD ICONS FOR PersonPanel");
		this.name.add(nameLab);
		this.life.add(new JLabel("L"));
		this.life.add(lifeLab);
		this.hand.add(new JLabel("H"));
		this.hand.add(handLab);
		this.deck.add(new JLabel("D"));
		this.deck.add(deckLab);
		this.graveyard.add(new JLabel("G"));
		this.graveyard.add(graveyardLab);
		boundStats.add(this.name);
		boundStats.add(this.life);
		boundStats.add(this.hand);
		boundStats.add(this.deck);
		boundStats.add(this.graveyard);
		add(new JLabel(portrait));
		add(boundStats);
	}
	
	private void redraw() {
		nameLab.setText(nameStr.toUpperCase());
		lifeLab.setText(lifeInt.toString());
		handLab.setText(handInt.toString());
		deckLab.setText(deckInt.toString());
		graveyardLab.setText(graveyardInt.toString());
	}
	
	public void update(int life, int hand, int deck, int graveyard) {
		this.lifeInt = life;
		this.handInt = hand;
		this.deckInt = deck;
		this.graveyardInt = graveyard;
		redraw();
	}
	
	public void update(HashMap<String, Integer> p) {
		this.lifeInt = p.get("Life");
		this.handInt = p.get("Hand");
		this.deckInt = p.get("Deck");
		this.graveyardInt = p.get("Graveyard");
		redraw();
	}
	

}
