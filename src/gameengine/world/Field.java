package gameengine.world;

import gameengine.graphicengine.BackgroundGraphicData;
import gameengine.graphicengine.Layer;

public abstract class Field extends BackgroundObject {
	public Field(BackgroundGraphicData bgd) {
		super(bgd);
		layerId = Layer.BOTTOM_LAYER+1;
	}
	public abstract boolean isWithin(float xPos, float yPos);

}
