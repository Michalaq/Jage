package gameengine.levels;


public abstract class LevelCreator {
	protected static int levelCount;
	public abstract void loadLevelData();
	public static int getLevelCount() {
		return levelCount;
	}
}
