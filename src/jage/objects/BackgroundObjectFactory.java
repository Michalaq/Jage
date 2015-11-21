package jage.objects;

import jage.world.BackgroundScenery;
import jage.world.CircularField;
import jage.world.Field;
import jage.world.RectangularField;

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
