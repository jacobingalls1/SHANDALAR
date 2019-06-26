package game_display;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import card.Card;
import card.CardPanel;
import card.SmallPanel;

public class CardFocus extends JPanel {
	
	Card card;
	CardPanel cardPanel;

	public CardFocus() {
		super();
		setMinimumSize(new Dimension(200, 400));
		setBorder(new EtchedBorder());
	}
	
	public void setCard(Card card) {
		this.card = card;
	}
	
	public void redraw() {
		removeAll();
		cardPanel = card.getCardFrame(false);
		add(cardPanel);
		this.setVisible(true);
		this.repaint();
	}
	
	public void update(Card card) {
		setCard(card);
		redraw();
	}
}
