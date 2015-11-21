package jage.soundengine;

import java.util.Map;

public abstract class MusicManager implements BackgroundMusicManager {
	protected static Map<String, SoundEffect> soundEffects;
	protected static Music levelMusic[];
	protected static Music menuMusic[]; // TODO
	
	
	public abstract void loadSoundData();
	public abstract void endWork();
	
	public void init() {
		initWorldObjectSounds();
	}
	protected abstract void initWorldObjectSounds();
	public static Music getLevelMusicByLevelId(int levelId) {
		return levelMusic[levelId];
	}
}
