package gameengine.objects;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import gameengine.graphicengine.BackgroundGraphicData;
import gameengine.graphicengine.GraphicsDrawer;
import gameengine.transformations.Transformation;

public abstract class TextureObject extends GraphicalObject {
	protected BackgroundGraphicData currentGraphicData;
	protected float offsetX, offsetY;
	protected List<Transformation<TextureObject>> transformations = new LinkedList<Transformation<TextureObject>>();
	
	public synchronized void addTransformation(Transformation<TextureObject> transformation) {
		transformations.add(transformation);
		transformation.prepare(this);
	}
	
	public float getOffsetX() {
		return offsetX;
	}
	
	public float getOffsetY() {
		return offsetY;
	}
	
	public void shiftX(float offsetX) {
		this.offsetX += offsetX;
	}
	
	public void shiftY(float offsetY) {
		this.offsetY += offsetY;
	}
	
	public void setOffsetX(float offsetX) {
		this.offsetX = offsetX;
	}
	
	public void setOffsetY(float offsetY) {
		this.offsetY = offsetY;
	}
	
	@Override
	public BackgroundGraphicData getGraphicData() {
		return currentGraphicData;
	}
	
	@Override
	public void draw(final GraphicsDrawer graphicsDrawer) {
		graphicsDrawer.drawBackground(getGraphicData());

	}
	
	public void update() {
		Iterator<Transformation<TextureObject>> it = transformations.iterator();
		Transformation<TextureObject> t;
		while (it.hasNext()) {
			t = it.next();
			t.apply(this);
			if (t.isFinished()) it.remove();
		}
		getGraphicData().update(this);
	}

}
