package card;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class SmallPanel extends JPanel implements MouseListener {
	
	Color color;
	ImageIcon art;
	JPanel top;
	boolean focus;
	Card card;
	
	public SmallPanel(Color background, ImageIcon cardArt, JPanel top, Card c) {
		focus = false;
		this.top = top;
		art = cardArt;
		color = background;
		card = c;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(color);
		setBorder(new EtchedBorder(EtchedBorder.RAISED));
		add(top);
		JLabel jl = new JLabel(art);
		jl.setAlignmentX(CENTER_ALIGNMENT);
		add(jl);
		this.setMaximumSize(new Dimension(150,90));
		addMouseListener(this);
	}
	
	public boolean getFocus() {
		return focus;
	}
	
	public Card getCard() {
		return card;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		focus = true;
		System.out.println("IN");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		focus = false;
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
