package jage.world;

import jage.graphicengine.BackgroundGraphicData;
import jage.graphicengine.Layer;

public abstract class Field extends BackgroundObject {
	public Field(BackgroundGraphicData bgd) {
		super(bgd);
		layerId = Layer.BOTTOM_LAYER+1;
	}
	public abstract boolean isWithin(float xPos, float yPos);

}
