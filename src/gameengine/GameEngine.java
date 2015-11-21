package gameengine;

import gameengine.graphicengine.GraphicData;
import gameengine.graphicengine.GraphicDataFactory;
import gameengine.graphicengine.GraphicalResourceIdManager;
import gameengine.graphicengine.GraphicsDrawer;
import gameengine.input.ClickSource;
import gameengine.levels.LevelCreator;
import gameengine.menus.MenuManager;
import gameengine.objects.BackgroundObjectFactory;
import gameengine.screens.GameScene;
import gameengine.screens.Level;
import gameengine.soundengine.MusicManager;

public class GameEngine {
	protected /**/ GraphicsDrawer graphicsDrawer;
	protected /**/ GameThread gameThread;
	protected /**/ BackgroundObjectFactory backgroundObjectFactory;
	protected /**/ boolean initialized = false;
	protected /**/ boolean gameRunning = false;
	protected static Debugger debugger;
	protected static GameState currentState = GameState.MENU_MAIN;
	protected static GameState previousState;
	protected static GameScene nextGameScene;
	protected GameScene currentGameScene;
	protected MusicManager musicManager;
	//
	protected static ClickSource levelClickSource;
	protected static boolean stateChanged = false;
	
	public GameEngine(GraphicsDrawer gd, GameThread gt, GraphicalResourceIdManager grid,
					  GraphicDataFactory gdf, MusicManager mm, ClickSource levelClickSource,
					  MenuManager menum, LevelCreator lc) {
		if (!initialized) {
			graphicsDrawer = gd;
			grid.loadIds();
			gdf.loadGraphics();
			GraphicData.setMultipliers(GraphicsDrawer.getGraphicResizeMultiplierX(),
										GraphicsDrawer.getGraphicResizeMultiplierY());
			

			GameEngine.levelClickSource = levelClickSource;
			BackgroundObjectFactory.init(gdf);
			GameThread.init(this);
			gameThread = gt;

			lc.loadLevelData();
			musicManager = mm;
			mm.loadSoundData();
			mm.init();
			nextGameScene = null;
			menum.init();
			currentGameScene = MenuManager.getMainMenu();
			currentState = GameState.MENU_MAIN;
			previousState = GameState.MENU_MAIN;
			initialized = true;
			gameThread.start();
		}
	}
	public static void sendDebugMessage(String type, String msg) {
		debugger.print(type, msg);
	}
	public static void setDebugger(Debugger d) {
		debugger = d;
	}
	public boolean isRunning() {
		return gameRunning;
	}
	public void start() {
		gameRunning = true;
	}
	
	public void pause() {
		setGameState(GameState.GAME_PAUSED);
	}
	
	public void resume() {
		setGameState(previousState);
	}
	
	public GameScene getGameScene() {
		return currentGameScene;
	}
	public void end() {
		musicManager.endWork();
		try {
            gameRunning = false;               //Tells thread to stop
            gameThread.join();                           //Removes thread from mem.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadLevel(Level level) {
		nextGameScene = level;
		setGameState(GameState.LEVEL_RUNNING);
	}
	
	public static void changeGameScene(GameScene scene, GameState state) {
		nextGameScene = scene;
		setGameState(state);
	}
	
	public synchronized void updateGameState() {
		if (stateChanged) {
			switch(previousState) {
				case MENU_MAIN : case MENU_CHOOSE_LEVEL : currentGameScene.pause(); break;
				case LEVEL_RUNNING : {
					if (currentState == GameState.GAME_PAUSED) {
						currentGameScene.pause();
					} else {
						currentGameScene.destroy();
					}
					break;
				}
				default : break;
			}
			switch(currentState) {
				case MENU_MAIN : case MENU_CHOOSE_LEVEL : currentGameScene = nextGameScene; currentGameScene.resume(); break;
				case LEVEL_RUNNING : currentGameScene = nextGameScene; currentGameScene.resume(); break;
				default : break;				
			}
			stateChanged = false;
		}
	}
	public GameState getGameState() {
		return currentState;
	}
	
	public static void setGameState(GameState state) {
		if (state != currentState) {
			previousState = currentState;
			currentState = state;
			stateChanged = true;
		}
	}
	
	
}
