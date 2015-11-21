package gameengine.world;

import gameengine.graphicengine.BackgroundGraphicData;
import gameengine.graphicengine.Layer;

public class BackgroundScenery extends BackgroundObject {
	protected boolean wholeScreen = true;	
	protected float xStart, yStart, xEnd, yEnd;
	
	public BackgroundScenery(BackgroundGraphicData bgd) {
		super(bgd);
	}
	
	public BackgroundScenery(BackgroundGraphicData bgd, float xStart, float yStart, float xEnd, float yEnd) {
		super(bgd);
		layerId = Layer.BOTTOM_LAYER;
		wholeScreen = false;
		this.xStart = xStart;
		this.yStart = yStart;
		this.xEnd = xEnd;
		this.yEnd = yEnd;
	}
	
	public boolean isOnWholeScreen() {
		return wholeScreen;
	}
}
