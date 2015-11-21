package gameengine.world;

import gameengine.graphicengine.BackgroundGraphicData;
import gameengine.objects.TextureObject;

public abstract class BackgroundObject extends TextureObject {
	
	public BackgroundObject(BackgroundGraphicData bgd) {
		currentGraphicData = bgd;
	}
}
