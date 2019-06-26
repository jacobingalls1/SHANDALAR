package card;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class CardPanel extends JPanel {
	JPanel panel;
	JLabel label;
	RulesPanel rp;
	ImageIcon back = null;
	Color background = null;
	ImageIcon art;
	JPanel mana;
	String name;
	CardColor color;
	JPanel bottom;
	JPanel middle;
	public CardPanel(ImageIcon background, ImageIcon cardArt, JPanel manaCost, RulesPanel rules, JPanel middle, JPanel bottom, String name, CardColor color, Boolean useRules) {
		super();
		back = background;
		art = cardArt;
		mana = manaCost;
		rp = rules;
		this.name = name;
		this.color = color;
		this.bottom = bottom;
		this.middle = middle;
		fill(useRules);
	}
	public CardPanel(Color background, ImageIcon cardArt, JPanel manaCost, RulesPanel rules, JPanel bottom, JPanel middle, String name, CardColor color, Boolean useRules) {
		super();
		this.background = background;
		art = cardArt;
		mana = manaCost;
		rp = rules;
		this.name = name;
		this.color = color;
		this.bottom = bottom;
		this.middle = middle;
		fill(useRules);
	}
	

	
	private void fill(Boolean useRules) {
		
		setMaximumSize(new Dimension(150, 400));
//		setLayout(new GridBagLayout());
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(background);
		setBorder(new EtchedBorder(EtchedBorder.RAISED));
//		add(new JLabel(back));
//		if (back == null) {
//			setBackground(background);
//		} else {
//			JLabel backer = new JLabel();
//			backer.setIcon(back);
//			backer.setLayout(new BorderLayout());
//			setContentPane(backer);
//		}
		
		JPanel jp = new JPanel();
		jp.setMaximumSize(new Dimension(300, 20));
		jp.setMinimumSize(new Dimension(300, 20));
		jp.setBorder(new BevelBorder(BevelBorder.RAISED));
		jp.setLayout(new BorderLayout());
		JLabel jl = new JLabel(name);
		jl.setMaximumSize(new Dimension(10, 20));
		Color color = this.color.mutedHue();
		mana.setBackground(color);
		jp.add(jl, BorderLayout.CENTER);
		jp.add(mana, BorderLayout.EAST);
		jp.setBackground(color);
		jp.setAlignmentX(CENTER_ALIGNMENT);
		
		add(jp);
		
		JLabel artL = new JLabel(art);
		artL.setMaximumSize(new Dimension(300, 180));
		artL.setMinimumSize(new Dimension(300, 180));
		artL.setBackground(new Color(255,255,255));
		artL.setAlignmentX(CENTER_ALIGNMENT);
		
		add(artL);
		
		if (useRules) {
			add(middle);
			
			rp.setBackground(background);
			rp.setAlignmentX(CENTER_ALIGNMENT);
			
			add(rp);
			
			add(bottom);
		}
	}
}
