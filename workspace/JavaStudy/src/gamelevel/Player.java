package gamelevel;

public class Player {
	private PlayerLevel level;

	public Player() {
		level = new BeginnerLevel();
		level.showLevelMessage();
	}
	
	public PlayerLevel getLevel() {
		return level;
	}

	public void upgradeLevel() {
		if(level instanceof BeginnerLevel) {
			level = new AdvancedLevel();
		}else if(level instanceof AdvancedLevel) {
			level = new SuperLevel();
		}
		level.showLevelMessage();
	}

	public void play(int count) {
		level.go(count);
	}
}
