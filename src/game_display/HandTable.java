package game_display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import card.Card;
import card.CardPanel;
import card.SmallPanel;

public class HandTable extends JPanel {
	JPanel panel = new JPanel();
	ArrayList<Card> hand;
	ArrayList<SmallPanel> cards;
	JScrollPane scroll;
	MouseListener m;
	
	public HandTable() {
		super();
//		setMaximumSize(new Dimension(800, 100));
//		setMinimumSize(new Dimension(800, 100));
		panel = new JPanel();
//		panel.setMaximumSize(new Dimension(800, 100));
//		panel.setMinimumSize(new Dimension(800, 100));
		panel.setBackground(new Color(200,200,200));
		panel.setLayout(new GridLayout(1, 0));
		scroll = new JScrollPane(panel);
//		scroll.setMaximumSize(new Dimension(800, 100));
		scroll.getViewport().setSize(new Dimension(800, 100));
		cards = new ArrayList<SmallPanel>();
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	}
	
	public void redraw() {
		panel.removeAll();
		for (int i = 0; i < hand.size(); i++) {
			System.out.println(hand.get(i).getName());
			SmallPanel sp = hand.get(i).getSmallPanel();
			sp.addMouseListener(m);
			cards.add(sp);
			panel.add(sp);
		}
		add(scroll);
	}
	
	public void update(ArrayList<Card> hand, MouseListener m) {
		this.hand = hand;
		this.m = m; 
		redraw();
	}
	
	public ArrayList<SmallPanel> getCards() {
		return cards;
	}
}
