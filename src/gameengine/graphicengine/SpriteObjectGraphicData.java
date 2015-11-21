package gameengine.graphicengine;

import gameengine.objects.SpriteObject;

public abstract class SpriteObjectGraphicData extends GraphicData {
	protected boolean animated = false, prepared = false;
	protected float x, y, currentWidth = 1, currentHeight = 1, width = 1, height = 1;
	protected int frame, frameCount;
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void update(SpriteObject wo) {
		if (!prepared) {
			width = wo.getWidth();
			height = wo.getHeight();
			prepared = true;
		}
		//ustawiamy tutaj x,y na lewy gorny rog
		currentWidth = wo.getWidth();
		currentHeight = wo.getHeight();
		x = (wo.getX() - wo.getWidth()/2);///multiplier;
		y = (wo.getY() - wo.getHeight()/2);///multiplier;
		if (animated) {
			frame = (frame+1) % frameCount;
		}
	}
}
