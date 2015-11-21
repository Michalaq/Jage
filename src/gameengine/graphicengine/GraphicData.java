package gameengine.graphicengine;

public abstract class GraphicData {
	protected static float multiplierX, multiplierY;
	public static void setMultipliers(float multiX, float multiY) {
		multiplierX = multiX;
		multiplierY = multiY;
	}
}
