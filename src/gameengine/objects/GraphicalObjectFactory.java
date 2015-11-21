package gameengine.objects;

import gameengine.graphicengine.GraphicDataFactory;

public abstract class GraphicalObjectFactory {
	protected static GraphicDataFactory graphicDataFactory;
	
	public static void init(GraphicDataFactory gdf) {
		graphicDataFactory = gdf;
	}
}
