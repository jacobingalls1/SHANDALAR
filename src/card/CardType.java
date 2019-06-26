package card;

public enum CardType {
	INSTANT		("Instant"),
	SORCERY		("Sorcery"),
	CREATURE	("Creature"),
	ARTIFACT	("Artifact"),
	ENCHANTMENT	("Enchantment"),
	LAND		("Land"),
	EMBLEM		("Emblem"),
	PLANESWALKER("Planeswalker");
	
	private final String type;
	
	private CardType(String type) {
		this.type = type;
	}
}