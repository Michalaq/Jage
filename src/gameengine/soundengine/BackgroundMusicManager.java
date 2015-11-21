package gameengine.soundengine;

public interface BackgroundMusicManager {
	public void setBackgroundMusic(Music music);
	public void changeBackgroundMusic(Music toMusic);
	public void playBackgroundMusic();
	public void stopBackgroundMusic();
	public void pauseBackgroundMusic();
	public void resumeBackgroundMusic();
}
