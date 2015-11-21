package jage.transformations.physics;

import jage.objects.GraphicalObject;
import jage.transformations.Transformation;

public class VelocityTransformation<T extends GraphicalObject> extends Transformation<T> {
	protected float x, y;
	
	public VelocityTransformation(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void prepare(T so) {
	}

	@Override
	public boolean isFinished() {
		return false;
	}
	
	@Override
	public void apply(T so) {
		so.addX(x);
		so.addY(y);
	}

}
