package jage.objects;

import jage.graphicengine.GraphicData;
import jage.graphicengine.InLayerDrawable;

public abstract class GraphicalObject implements InLayerDrawable {
	protected int layerId;
	protected float x, y, z;
	
	public final int getTargetLayerId() {
		return layerId;
	}
	protected abstract GraphicData getGraphicData();
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public void addX(float x) {
		this.x += x;
	}
	
	public void addY(float y) {
		this.y += y;
	}

}
