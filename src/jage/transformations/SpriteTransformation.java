package jage.transformations;

import jage.objects.SpriteObject;

public abstract class SpriteTransformation {
	public abstract void prepare(SpriteObject so);
	public abstract boolean isFinished();
	public abstract void apply(SpriteObject so);
}
