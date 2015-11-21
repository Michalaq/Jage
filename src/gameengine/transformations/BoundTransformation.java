package gameengine.transformations;

import gameengine.objects.GraphicalObject;

public abstract class BoundTransformation<T extends GraphicalObject> extends Transformation<T> {
	protected float xStart, yStart, xEnd, yEnd;
	
	public BoundTransformation(float xStart, float yStart, float xEnd, float yEnd) {
		this.xEnd = xEnd;
		this.xStart = xStart;
		this.yEnd = yEnd;
		this.yStart = yStart;
	}
	
	protected abstract void onXReached();
	protected abstract void onYReached();

}
