package card;
import java.awt.Color;

public enum CardColor {
	WHITE		("White"),
	BLUE		("Blue"),
	BLACK		("Black"),
	RED 		("Red"),
	GREEN		("Green"),
	COLORLESS	("Colorless"),
	MULTICOLORED("Multicolored")
	;
	
	private String color;
	
	private CardColor(String color) {
		this.color = color;
	}
	
	public Color hue() {
		switch (color) {
		case "White":
			return new Color(240, 240, 240);
		case "Blue":
			return new Color(37, 69, 124);
		case "Black":
			return new Color(25, 25, 25);
		case "Red":
			return new Color(196, 44, 27);
		case "Green":
			return new Color(38, 127, 0);
		case "Multicolored":
			return new Color(212, 175, 55);
		default:
			return new Color(100, 100, 100);
		}
	}
	
	public Color mutedHue() {
		switch (color) {
		case "Black":
			return new Color(100, 100, 100);
		default:
			return hue().brighter();
		}
		
	}
}
