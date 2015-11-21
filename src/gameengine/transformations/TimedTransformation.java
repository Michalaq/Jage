package gameengine.transformations;

public abstract class TimedTransformation extends SpriteTransformation {
	protected int timeLeft;
	
	public TimedTransformation(int duration) {
		timeLeft = duration;
	}
	
	@Override
	public boolean isFinished() {
		return timeLeft == 0;
	}
}
