package gameengine.objects;

import gameengine.world.BackgroundScenery;
import gameengine.world.CircularField;
import gameengine.world.Field;
import gameengine.world.RectangularField;

public class BackgroundObjectFactory extends GraphicalObjectFactory {
	
	public static Field createCircularField(String texture, float x, float y, float radius) {
		return new CircularField(x, y, radius,
			   graphicDataFactory.createCircularFieldGraphicData(
					   texture, x,
					   y,
					   radius));
	}
	
	public static Field createRectangularField(String texture, float x,
												float y, float xEnd, float yEnd) {
		return new RectangularField(x, y, xEnd, yEnd,
			   graphicDataFactory.createRectangularFieldGraphicData(texture, x, y, xEnd, yEnd));
	}	
	
	public static BackgroundScenery createBackgroundScenery(String texture) {
		return new BackgroundScenery(graphicDataFactory.createSceneryGraphicData(texture));
	}
}
