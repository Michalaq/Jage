package gameengine.world;

import gameengine.graphicengine.GraphicsDrawer;
import gameengine.graphicengine.RectangularBackgroundGraphicData;

public class RectangularField extends Field {
	protected RectangularBackgroundGraphicData currentGraphicData;
	private float x, y, xEnd, yEnd;
	
	public RectangularField(float x, float y, float xEnd, float yEnd, RectangularBackgroundGraphicData bgd) {
		super(bgd);
		currentGraphicData = bgd;
		this.x = x;
		this.y = y;
		this.xEnd = xEnd;
		this.yEnd = yEnd;
	}
	
	@Override
	public boolean isWithin(float xPos, float yPos) {
		return ((xPos >= x && xPos <= xEnd) && (yPos >= y && yPos <= yEnd));
	}

	@Override
	public void update() {

	}
	
	@Override
	public RectangularBackgroundGraphicData getGraphicData() {
		return currentGraphicData;
	}
	
	@Override
	public void draw(final GraphicsDrawer gd) {
		gd.drawRectangularBackground(getGraphicData());
	}

}
