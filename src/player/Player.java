package player;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;

import card.Card;

public class Player {
	Deck deck;
	ArrayList<Card> hand = new ArrayList<Card>();
	ArrayList<Card> graveyard = new ArrayList<Card>();
	HashMap<Card, Boolean> exile = new HashMap<Card, Boolean>();
	HashMap<String, Integer> counters = new HashMap<String, Integer>();
	HashMap<PlayerFlag, Boolean> flags = new HashMap<PlayerFlag, Boolean>();
	private String name;
	public Player(Deck deck, String name) {
		super();
		this.deck = deck;
		this.deck.shuffle();
		this.setName(name);
	}
	
	public void doStandardStart() {
		counters.put("Life", 20);
	}
	
	public void draw(int cards) {
		for (int i = 0; i < cards; i++) {
			if (deck.getCount() == 0) {
				flags.put(PlayerFlag.OVERDRAW, true);
				break;
			}
			hand.add(deck.draw());
		}
	}
	
	public void setCounters(HashMap<String, Integer> count) {
		counters = count;
	}
	
	public void addExile(Card c, Boolean b) {
		exile.put(c, b);
	}
	
	public void addGraveyard(Card c) {
		graveyard.add(c);
	}
	
	public void changeCounter(String s, Integer change) {
		if (counters.containsKey(s)) {
			counters.put(s, counters.get(s) + change);
		} else {
			counters.put(s, change);
		}
	}
	
	public void exileFromHand(Card c, Boolean b) {
		hand.remove(c);
		exile.put(c, b);
	}
	
	public void discard(Card c) {
		hand.remove(c);
		graveyard.add(c);
	}
	
	
	public Card removeFromHand(Card c) {
		hand.remove(c);
		return c;
	}
	
	public Boolean spendCounters(String counter, Integer number) {
		if (counters.get(counter) - number >= 0) {
			counters.put(counter, counters.get(counter) - number);
			return true;
		}
		return false;
	}
	
	public ImageIcon getPortrait() {
		ImageIcon ii = new ImageIcon(Card.getConfigpath() + "portraits\\" + getName().replace(' ', '_') + ".jpg");
		return new ImageIcon(Card.getScaledImage(ii.getImage(), 150, 200));
	}
	
	public HashMap<String, Integer> stats() {
		HashMap<String, Integer> ph = new HashMap<String, Integer>(counters);
		System.out.println(ph.get("Life"));
		ph.put("Deck", deck.getCount());
		ph.put("Hand", hand.size());
		ph.put("Graveyard", graveyard.size());
		ph.put("Exile", exile.size());
		return ph;
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
