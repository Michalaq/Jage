package gameengine.world;

import gameengine.graphicengine.Layer;
import gameengine.objects.SpriteObject;

public abstract class WorldObject extends SpriteObject{
	public WorldObject(float x, float y, int width, int height) {
		super(x, y, width, height);
		layerId = Layer.BOTTOM_LAYER+2;
	}
	
	public boolean intersects(WorldObject other) {
		return (Math.abs(this.getX() - other.getX()) <= this.getWidth()/2 + other.getWidth()/2
						&& Math.abs(this.getY() - other.getY()) <= this.getHeight()/2 + other.getHeight()/2);
	}
}
