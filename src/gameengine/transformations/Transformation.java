package gameengine.transformations;

import gameengine.objects.GraphicalObject;


public abstract class Transformation<T extends GraphicalObject> {
	public abstract void prepare(T so);
	public abstract boolean isFinished();
	public abstract void apply(T so);
}
