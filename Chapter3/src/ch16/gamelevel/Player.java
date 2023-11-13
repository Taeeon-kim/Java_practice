package ch16.gamelevel;

public class Player {
	private PlayerLevel level;
	
	public Player() {
		level = new BeginnerLevel();
		level.showLevelMessage();
	}
		
	public PlayerLevel getLevel() {
		System.out.println(level);
		return level;
	}
	
	public void upgradeLevel(PlayerLevel level) {
		this.level = level;
		level.showLevelMessage();	
	}
	
	 public void play(int count) {
		level.go(count);
	}
	
	
}
