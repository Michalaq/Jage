package jage.graphicengine;

import jage.menus.controls.GameText;

public abstract class GraphicsDrawer {
	protected static final int defaultScreenHeight = 864;
	protected static final int defaultScreenWidth = 480;
	protected static final int fps = 30;
	protected static float graphicResizeMultiplierX, graphicResizeMultiplierY;
	
	//constructor calculating the multipliers
	public GraphicsDrawer(float screenWidth, float screenHeight) {
		graphicResizeMultiplierX = screenWidth/defaultScreenWidth;
		graphicResizeMultiplierY = screenHeight/defaultScreenHeight;
	}
	
	// abstract methods //
	public abstract void drawSpriteObject(SpriteObjectGraphicData wogd);
	public abstract void drawBackground(BackgroundGraphicData bgd);
	public abstract void drawCircularBackground(CircularBackgroundGraphicData cbgd);
	public abstract void drawRectangularBackground(RectangularBackgroundGraphicData rbgd);
	public abstract void drawCustomShapeBackground(CustomShapeBackgroundGraphicData csbgd);
	public abstract void drawText(GameText text);
	// end //
	
	public static final float getGraphicResizeMultiplierX() {
		return graphicResizeMultiplierX;
	}
	
	public static final float getGraphicResizeMultiplierY() {
		return graphicResizeMultiplierY;
	}	
	
	public static final int getFPS() {
		return fps;
	}
	public static final int getDefaultScreenHeight() {
		return defaultScreenHeight;
	}
	public static final int getDefaultScreenWidth() {
		return defaultScreenWidth;
	}

}
