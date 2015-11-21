package jage;

public class GameThread extends Thread {
	protected static GameEngine gameEngine;
	
	public static void init(GameEngine ge) {
		gameEngine = ge;
	}
	
	@Override
	public void run() {
		while(gameEngine.isRunning()) {
				gameEngine.getGameScene().update();
		}
	}
}
