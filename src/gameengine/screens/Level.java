package gameengine.screens;

import gameengine.soundengine.MusicalObject;

public abstract class Level extends SyncLayeredGameScene implements MusicalObject {
	protected static int levelCount = 0;
	protected final int id;
	protected int score;
	
	public Level(int layerCount, int id) {
		super(layerCount);
		this.id = id;
	}

}
