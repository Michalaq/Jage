package gameengine.menus.controls;

import gameengine.graphicengine.GraphicsDrawer;
import gameengine.graphicengine.InLayerDrawable;

public class GameText implements InLayerDrawable {
	protected String text;
	protected String colourString = "FF0000";
	protected int colour = Integer.valueOf(colourString.replace("#", ""), 16); // BLACK
	protected float x, y, z;
	protected int widthAvailable, heightAvailable;
	public GameText(String text, float x, float y, float z, int widthAvailable, int heightAvailable) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.z = z;
		this.widthAvailable = widthAvailable;
		this.heightAvailable = heightAvailable;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	public float getZ() {
		return z;
	}
	public int getWidthAvailable() {
		return widthAvailable;
	}
	public int getHeightAvailable() {
		return heightAvailable;
	}
	public void setX(float x) {
		this.x = x;
	}
	public void setY(float y) {
		this.y = y;
	}
	public void setZ(float z) {
		this.z = z;
	}
	public void addX(float x) {
		this.x += x;
	}
	public void addY(float y) {
		this.y += y;
	}	
	public void addZ(float z) {
		this.z += z;
	}
	public void setHeightAvailable(int height) {
		heightAvailable = height;
	}
	public void setWidthAvailable(int width) {
		widthAvailable = width;
	}
	public void setColour(String colourHexString) {
		colourString = colourHexString;
		colour = Integer.parseInt(colourString, 16);
	}
	public void setColour(int colourHexValue) {
		colour = colourHexValue;
		colourString = "#" + Integer.toHexString(colourHexValue);
	}
	public int getColour() {
		return colour;
	}
	public String getColourHexString() {
		return colourString;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public void draw(final GraphicsDrawer gd) {
		gd.drawText(this);
	}

	@Override
	public int getTargetLayerId() {
		return (int) z;
	}
}
