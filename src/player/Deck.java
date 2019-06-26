package player;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import card.Card;

public class Deck {
	protected static String configPath = Card.getConfigpath();
	ArrayList<String> deckList;
	ArrayList<Card> deck;
	Random r = new Random();
	public Deck(String config) {
		super();
		deckList = new ArrayList<String>();
		Scanner scan = null;
		
		try {
			scan = new Scanner(new File(configPath + "\\decks\\" + config + ".deck"));
		} catch (FileNotFoundException e) {
			System.out.println("Could not find " + config);
			e.printStackTrace();
		}
		while (scan.hasNextLine()) {
			deckList.add(scan.nextLine());
		}
		
		deck = new ArrayList<Card>();
		
		for (String s : deckList) {
			Card c = new Card(s);
			deck.add(c);
		}
	}
	
	public void shuffle() {
		for (int i = 0; i < deck.size(); i++) {
			int rand = r.nextInt(deck.size());
			Card ph = deck.get(rand);
			deck.set(rand, deck.get(i));
			deck.set(i, ph);
		}
	}
	
	public int getCount() {
		return deck.size();
	}
	
	public Card lookTop() {
		return deck.get(deck.size() - 1);
	}
	
	public Card draw() {
		Card ph = deck.get(deck.size() - 1);
		deck.remove(deck.size() - 1);
		return ph;
	}
	
	public ArrayList<Card> getDeck() {
		return deck;
	}
}
