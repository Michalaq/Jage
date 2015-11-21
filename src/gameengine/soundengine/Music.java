package gameengine.soundengine;

public abstract class Music extends SoundData {
	protected static boolean isMuted = false;
	protected int id;
	protected BackgroundMusicManager bgMusicManager;
	
	public Music(int soundId, BackgroundMusicManager bmm) {
		bgMusicManager = bmm;
		id = soundId;
	}
	
	@Override
	public void play() {
		if (!isMuted)
			bgMusicManager.changeBackgroundMusic(this);
	}
	
	public void stop() {
		if (!isMuted)
			bgMusicManager.stopBackgroundMusic();
	}
	
	public void pause() {
		if (!isMuted)
			bgMusicManager.pauseBackgroundMusic();
	}
	
	public void resume() {
		if (!isMuted)
			bgMusicManager.resumeBackgroundMusic();
	}
	
	public int getId() {
		return id;
	}
}
