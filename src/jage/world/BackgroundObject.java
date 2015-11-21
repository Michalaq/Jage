package jage.world;

import jage.graphicengine.BackgroundGraphicData;
import jage.objects.TextureObject;

public abstract class BackgroundObject extends TextureObject {
	
	public BackgroundObject(BackgroundGraphicData bgd) {
		currentGraphicData = bgd;
	}
}
