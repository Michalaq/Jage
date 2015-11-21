package gameengine.graphicengine;

public abstract class CircularBackgroundGraphicData extends BackgroundGraphicData {
	protected float x, y, radius;
	
	public CircularBackgroundGraphicData(float x, float y, float radius) {
		this.x = x*multiplierX;
		this.y = y*multiplierY;
		this.radius = radius*(multiplierX+multiplierY)/2;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getRadius() {
		return radius;
	}
}
