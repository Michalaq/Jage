package jage.graphicengine;

import jage.Coordinates;

import java.util.List;

public abstract class CustomShapeBackgroundGraphicData extends
		BackgroundGraphicData {
	protected List<Coordinates> edgeCoordinates;
	
	public CustomShapeBackgroundGraphicData(List<Coordinates> edgeCoordinates) {
		this.edgeCoordinates = edgeCoordinates;
	}
	
	public List<Coordinates> getEdgeCoordinates() {
		return edgeCoordinates;
	}
}
