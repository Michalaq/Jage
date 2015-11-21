package jage.menus.controls;

import jage.graphicengine.SpriteObjectGraphicData;

public class GameImage extends GameControl {

	public GameImage(float x, float y, int width, int height, SpriteObjectGraphicData image, int layerId) {
		super(x, y, width, height);
		currentGraphicData = image;
		currentGraphicData.update(this);
		this.layerId = layerId;
	}
	
}
