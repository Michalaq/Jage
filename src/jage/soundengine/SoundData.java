package jage.soundengine;

public abstract class SoundData {
	protected static boolean isMuted = false;
	public static void mute() {
		isMuted = true;
	}
	public static void unMute() {
		isMuted = false;
	}
	public abstract void play();
	public abstract int getDuration();
}
