package game_display;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import card.Card;
import card.SmallPanel;

public class Tableau extends JPanel {
	
	
	public Tableau() {
		setMinimumSize(new Dimension(800, 350));
		setLayout(new GridLayout(4,5));
		setBorder(new EtchedBorder());
	}
	
	public void addCard(SmallPanel c) {
		add(c);
	}
	
}
