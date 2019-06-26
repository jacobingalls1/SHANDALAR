package card;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

//import CardType
public class Card {
	static final String configPath = "C:\\Users\\Ophiuchus\\eclipse-workspace\\Shandalar\\src\\config\\";
	static HashMap<String, ImageIcon> recentImage300 = new HashMap<String, ImageIcon>();
	static HashMap<String, ImageIcon> recentImage150 = new HashMap<String, ImageIcon>();
	private String name;
	String manaCost;
	String set;
	int numInSet;
	String rarity;
	String typeText;
	String rulesText;
	String flavorText;
	String artistName;
	String creatureTag;
	boolean legendary;
	CardType cardType;
	CardColor color;
	
	public Card(String cardName) {
		super();
		setName(cardName);
		String info = null;
		Scanner scan = null;
		try {
			scan = new Scanner(new File(getConfigpath() + "cardInfo.config"));
		} catch (FileNotFoundException e) {
			System.out.println("Could not find 'cardInfo.config'");
			e.printStackTrace();
		}
		String ph = null;
		while (scan.hasNextLine()) {
			ph = scan.nextLine();
			if (ph.contains(getName())) {
				info = ph;
				break;
			}
		}
		scan.close();

//		System.out.println(info);
//		System.out.println(ph);
		String[] infoArr = info.split(";");
		
		manaCost = 		infoArr[1];
		set = 			infoArr[2];
		numInSet =		new Integer(infoArr[3]);
		rarity = 		infoArr[4];
		typeText = 		infoArr[5];
		rulesText = 	infoArr[6];
		flavorText = 	infoArr[7];
		creatureTag = 	infoArr[8];
		artistName =	infoArr[9];
		try {
			cardType = CardType.valueOf(typeText.split(" ")[0].toUpperCase());
		} catch (IllegalArgumentException e) {
			cardType = CardType.valueOf(typeText.split(" ")[1].toUpperCase());
		}
		
		ArrayList<String> arrList = new ArrayList<String>();
		for (String c : new String[]{"W", "U", "B", "R", "G"}) {
			if (manaCost.contains(c)) {
				arrList.add(c);
			}
		}

		if (arrList.size() > 1) {
			color = CardColor.MULTICOLORED;
		} else if (arrList.size() == 0) {
			color = CardColor.COLORLESS;
		} else {
			switch (arrList.get(0)) {
			case "W":
				color = CardColor.WHITE;
				break;
			case "U":
				color = CardColor.BLUE;
				break;
			case "B":
				color = CardColor.BLACK;
				break;
			case "R":
				color = CardColor.RED;
				break;
			case "G":
				color = CardColor.GREEN;
				break;
			}
		}
	}

	public static Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}
	
	public CardPanel getCardFrame(boolean artful) {
		if (artful) {
			return new CardPanel(this.getBackgroundFrame(), getCardArt300(), this.drawManaCost(this.manaCost), this.getRulesFrame(), this.getBottom(), this.getMiddle(), getName(), color, true);
		}
		return new CardPanel(this.getBackground(), getCardArt300(), this.drawManaCost(this.manaCost), this.getRulesFrame(), this.getBottom(), this.getMiddle(), getName(), color, true);	}
	
	public SmallPanel getSmallPanel() {
		return new SmallPanel(getBackground(), getCardArt150(), getTop(), this);
	}
	
	protected JPanel drawManaCost(String manaCost) {
		JPanel jp = new JPanel();
		jp.setSize(15, 15);
		Color color = this.color.mutedHue();
		for (int i = 0; i < manaCost.length(); i++) {
			JLabel jl = new JLabel(new ImageIcon(getScaledImage(new ImageIcon(getConfigpath() + "symbols\\" + manaCost.charAt(i) + ".png").getImage(), 17, 17)));
			jl.setSize(new Dimension(0, 17));
			jl.setOpaque(true);
			jl.setBackground(color);
			jp.add(jl);
		}
		jp.setBackground(color);
		return jp;
	}	
	
	protected JPanel getTop() {
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		JPanel jptemp = new JPanel();
		jptemp.setBackground(color.mutedHue());
		jptemp.add(new JLabel(getName()));
		jp.add(jptemp, BorderLayout.WEST);
		jp.setMaximumSize(new Dimension(150, 20));
//		jp.add(drawManaCost(manaCost), BorderLayout.EAST);
		jp.setBackground(color.mutedHue());
		return jp;
	}
	
	protected JPanel getMiddle() {
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		jp.add(new JLabel(typeText), BorderLayout.WEST);

		JPanel jptemp = new JPanel();
		jptemp.setBackground(new Color(150, 150, 150));
		jptemp.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		jptemp.add(new JLabel(rarity));
		jp.add(jptemp, BorderLayout.EAST);
			
		jp.setBackground(new Color(100, 100, 100));
		return jp;
	}
	
	protected JPanel getBottom() {
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		JPanel jptemp = new JPanel();
		jptemp.setBackground(new Color(100, 100, 100));
		jptemp.add(new JLabel(artistName));
		jp.add(jptemp, BorderLayout.WEST);

		if (creatureTag.contains("/")) {
			jptemp = new JPanel();
			jptemp.setBackground(new Color(150, 150, 150));
			jptemp.setBorder(new EtchedBorder(EtchedBorder.RAISED));
			jptemp.add(new JLabel(creatureTag));
			jp.add(jptemp, BorderLayout.EAST);
		}
		
		jp.setBackground(new Color(100, 100, 100));
		return jp;
	}
	
	protected ImageIcon getCardArt300() {
		if (recentImage300.containsKey(getName())) {
			return recentImage300.get(getName());
		}
		
		ImageIcon ii = new ImageIcon(getConfigpath() + "art\\" + getName().replace(' ', '_') + ".jpg");
		ii = new ImageIcon(getScaledImage(ii.getImage(), 300, 180));
		recentImage300.put(getName(), ii);
		return ii;
	}
	
	protected ImageIcon getCardArt150() {
		if (recentImage150.containsKey(getName())) {
			return recentImage150.get(getName());
		}
		
		ImageIcon ii = new ImageIcon(getConfigpath() + "art\\" + getName().replace(' ', '_') + ".jpg");
		ii = new ImageIcon(getScaledImage(ii.getImage(), 150, 90));
		recentImage150.put(getName(), ii);
		return ii;
	}
	
	protected RulesPanel getRulesFrame() {
		return new RulesPanel(rulesText, flavorText, color, cardType == CardType.LAND);
	}
	
	protected Color getBackground() {
		if (cardType == CardType.LAND) {
			return new Color(76, 51, 4);
		}
		return color.hue();
	}
	
	protected ImageIcon getBackgroundFrame() {
		return new ImageIcon(getConfigpath() + "background\\" + color.name() + ".png");
	}
	
	
	public static void main(String[] args) {
		JFrame jf = new JFrame("Card");
		jf.setSize(1500,1000);
		jf.setVisible(true);
		jf.setLayout(new FlowLayout());
		
		ArrayList<String> als = new ArrayList<String>();
		String info = null;
		Scanner scan = null;
		try {
			scan = new Scanner(new File(getConfigpath() + "test\\testList.config"));
		} catch (FileNotFoundException e) {
			System.out.println("Could not find 'testList.config'");
			e.printStackTrace();
		}
		String ph = null;
		while (scan.hasNextLine()) {
			als.add(scan.nextLine());
		}
		scan.close();
		
		ArrayList<Card> cards = new ArrayList<Card>();
//		ArrayList<CardPanel> cardPanels = new ArrayList<CardPanel>();
		ArrayList<SmallPanel> smallPanels = new ArrayList<SmallPanel>();
		for (String s : als) {
			Card card = new Card(s);
//			CardPanel cp = card.getCardFrame(false);
//			cards.add(card);
//			cardPanels.add(cp);
//			jf.add(cp);
			SmallPanel sp = card.getSmallPanel();
			cards.add(card);
			smallPanels.add(sp);
			jf.add(sp);
		}
		jf.setVisible(true);
	}

	public static String getConfigpath() {
		return configPath;
	}	
	
	public Boolean isLand() {
		return cardType == CardType.LAND;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
