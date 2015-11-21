package jage.screens;

import jage.graphicengine.Drawable;

public interface GameScene extends Drawable {
	public void update(); // implements GameState
	public void pause();
	public void resume();
	public void destroy();
}
