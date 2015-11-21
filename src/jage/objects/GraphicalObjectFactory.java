package jage.objects;

import jage.graphicengine.GraphicDataFactory;

public abstract class GraphicalObjectFactory {
	protected static GraphicDataFactory graphicDataFactory;
	
	public static void init(GraphicDataFactory gdf) {
		graphicDataFactory = gdf;
	}
}
