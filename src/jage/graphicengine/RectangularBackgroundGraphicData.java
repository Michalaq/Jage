package jage.graphicengine;

public abstract class RectangularBackgroundGraphicData extends BackgroundGraphicData {
	protected float x, y, xEnd, yEnd;
	
	public RectangularBackgroundGraphicData(float x, float y, float xEnd, float yEnd) {
		this.x = x*multiplierX;
		this.y = y*multiplierY;
		this.xEnd = xEnd*multiplierX;
		this.yEnd = yEnd*multiplierY;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getXEnd() {
		return xEnd;
	}
	
	public float getYEnd() {
		return yEnd;
	}

}
