package gameengine.screens;

import gameengine.graphicengine.Drawable;

public interface GameScene extends Drawable {
	public void update(); // implements GameState
	public void pause();
	public void resume();
	public void destroy();
}
