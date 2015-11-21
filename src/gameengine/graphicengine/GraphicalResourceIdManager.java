package gameengine.graphicengine;

public abstract class GraphicalResourceIdManager {
	protected static String[] spriteIds;
	protected static String[] textureIds;
	public static String[] getTextureIds() {
		return textureIds.clone();
	}
	public static String[] getSpriteIds() {
		return spriteIds.clone();
	}
	public abstract void loadIds();
}
