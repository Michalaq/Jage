package gameengine.transformations;

import gameengine.objects.SpriteObject;

public abstract class SpriteTransformation {
	public abstract void prepare(SpriteObject so);
	public abstract boolean isFinished();
	public abstract void apply(SpriteObject so);
}
