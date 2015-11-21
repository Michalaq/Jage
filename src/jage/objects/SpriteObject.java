package jage.objects;

import jage.graphicengine.GraphicsDrawer;
import jage.graphicengine.SpriteObjectGraphicData;
import jage.transformations.Transformation;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class SpriteObject extends GraphicalObject {
	protected SpriteObjectGraphicData currentGraphicData;
	protected int width, height;
	protected float z;
	protected List<Transformation<SpriteObject>> transformations = new LinkedList<Transformation<SpriteObject>>();
	
	public SpriteObject(float x, float y, int width, int height) {
		this(x, y, 0, width, height);
	}
	
	public SpriteObject(float x, float y, float z, int width, int height) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.width = width;
		this.height = height;
	}
	
	public synchronized void addTransformation(Transformation<SpriteObject> transformation) {
		transformations.add(transformation);
		transformation.prepare(this);
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	protected SpriteObjectGraphicData getGraphicData() {
		return currentGraphicData;
	}
	
	@Override
	public void draw(final GraphicsDrawer graphicsDrawer) {
		graphicsDrawer.drawSpriteObject(getGraphicData());
	}
	
	public synchronized void update() {
		Iterator<Transformation<SpriteObject>> it = transformations.iterator();
		Transformation<SpriteObject> t;
		while (it.hasNext()) {
			t = it.next();
			t.apply(this);
			if (t.isFinished()) it.remove();
		}
		getGraphicData().update(this);
	}
}
