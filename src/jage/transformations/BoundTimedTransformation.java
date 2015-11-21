package jage.transformations;

import jage.objects.GraphicalObject;


public abstract class BoundTimedTransformation<T extends GraphicalObject> extends BoundTransformation<T> {
	protected int timeLeft;
	
	public BoundTimedTransformation(float xStart, float yStart, float xEnd, float yEnd, int duration) {
		super(xStart, yStart, xEnd, yEnd);
		timeLeft = duration;
	}
	
	@Override
	public boolean isFinished() {
		return timeLeft == 0;
	}

}
