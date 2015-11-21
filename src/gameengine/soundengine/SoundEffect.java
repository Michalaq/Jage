package gameengine.soundengine;

public abstract class SoundEffect extends SoundData {
	protected static boolean isMuted = false;
	public abstract void playLoop(int times);
}
