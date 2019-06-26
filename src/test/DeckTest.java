package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import card.Card;
import player.Deck;

class DeckTest {

	Deck deck;

	 @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
    	deck = new Deck("test2");
    }

    @Test
    void lengthTest() {
    	assertTrue(deck.getCount() == 60);
    }
    
    @Test
    void shuffleTest() {
    	Card ph1 = deck.lookTop();
    	deck.shuffle();
    	Card ph2 = deck.lookTop();
    	deck.shuffle();
    	Card ph3 = deck.lookTop();
    	deck.shuffle();
    	Card ph4 = deck.lookTop();
    	deck.shuffle();
    	Card ph5 = deck.lookTop();
    	deck.shuffle();
    	assertFalse(deck.equals(ph1) && deck.equals(ph2) && deck.equals(ph3) && deck.equals(ph4) && deck.equals(ph5));
    }
    
    @Test
    void drawTest() {
    	ArrayList<Card> alc = new ArrayList<Card>();
    	int count = deck.getCount();
    	for (int i = 0; i < 7; i++) {
    		alc.add(deck.draw());
    	}
    	assertTrue(deck.getCount() == count - 7);
    	assertFalse(alc.contains(deck.lookTop()));
    }
}
