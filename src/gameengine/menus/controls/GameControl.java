package gameengine.menus.controls;

import gameengine.objects.SpriteObject;

public abstract class GameControl extends SpriteObject {
	protected boolean visible = true;
	
	public GameControl(float x, float y, int width, int height) {
		super(x, y, width, height);
	}
	
	public void setVisibility(boolean visible) {
		this.visible = visible;
	}
	
	public boolean isVisible() {
		return visible;
	}

}
