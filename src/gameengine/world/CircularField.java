package gameengine.world;

import gameengine.graphicengine.CircularBackgroundGraphicData;
import gameengine.graphicengine.GraphicsDrawer;

public class CircularField extends Field {
	protected CircularBackgroundGraphicData currentGraphicData;
	private float x, y;
	private float radius;
	
	public CircularField(float x, float y, float radius, CircularBackgroundGraphicData bgd) {
		super(bgd);
		currentGraphicData = bgd;
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	@Override
	public boolean isWithin(float xPos, float yPos) {
		return Math.sqrt((x-xPos)*(x-xPos) + (y-yPos)*(y-yPos)) <= radius;
	}
	
	@Override
	public CircularBackgroundGraphicData getGraphicData() {
		return currentGraphicData;
	}
	
	@Override
	public void draw(final GraphicsDrawer gd) {
		gd.drawCircularBackground(getGraphicData());
	}
}
