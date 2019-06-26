package player;

import java.util.HashMap;

public enum GameMode {
	NORMAL		("Normal");
	
	private final String type;
	
	private GameMode(String type) {
		this.type = type;
	}
}
