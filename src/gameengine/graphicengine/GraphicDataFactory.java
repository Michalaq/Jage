package gameengine.graphicengine;

import java.util.List;

import gameengine.Coordinates;

public abstract class GraphicDataFactory {
	public final void loadGraphics() {
		for (String sprite : GraphicalResourceIdManager.getSpriteIds()) {
			loadSprite(sprite);
		}
		for (String texture : GraphicalResourceIdManager.getTextureIds()) {
			loadTexture(texture);
		}
	}
	protected abstract <T> T getSpriteResource(String sprite);
	protected abstract <T> T getResizedSpriteResource(String sprite, float xResized, float yResized);
	protected abstract <T> T getResizedSpriteResource(String sprite, int toWidth, int toHeight);
	protected abstract <T> T getTextureResource(String texture);
	protected abstract void loadSprite(String sprite);
	protected abstract void loadTexture(String texture);
	
	public abstract SpriteObjectGraphicData createSpriteObjectGraphicData(String sprite);
	public abstract SpriteObjectGraphicData createResizedSpriteObjectGraphicData(String sprite, int toWidth, int toHeight);
	public abstract SpriteObjectGraphicData createResizedSpriteObjectGraphicData(String sprite, float xResized, float yResized);
	
	
	//public abstract SpriteObjectGraphicData createButtonStateGraphicData(Sprite btnSprite, int width, int height);
	public abstract BackgroundGraphicData createSceneryGraphicData(String texture);
	public abstract CircularBackgroundGraphicData createCircularFieldGraphicData(String texture, float x, float y, float radius);
	public abstract RectangularBackgroundGraphicData createRectangularFieldGraphicData(String texture, float x, float y, float xEnd, float yEnd);
	public abstract CustomShapeBackgroundGraphicData createCustomShapeFieldGraphicData(String texture, List<Coordinates> edgeCoordinates);
}
