package gameengine.menus;

import gameengine.input.ClickSource;
import gameengine.levels.LevelCreator;
import gameengine.screens.MenuScene;

public abstract class MenuManager {
	protected static MenuScene mainMenu, chooseLevelMenu, defaultMenu;
	protected static ClickSource menuClickSource;
	protected static LevelCreator levelCreator;
	protected abstract MenuScene createMainMenu();
	protected abstract MenuScene createChooseLevelMenu();
	
	public void init() {
		mainMenu = createMainMenu();
		chooseLevelMenu = createChooseLevelMenu();
		defaultMenu = mainMenu;
	}
	
	public MenuManager(ClickSource menuClickSource, LevelCreator lc) {
		MenuManager.menuClickSource = menuClickSource;
		MenuManager.levelCreator = lc;
	}
	
	public static MenuScene getMainMenu() {
		return mainMenu;
	}
	
	public static MenuScene getChooseLevelMenu() {
		return chooseLevelMenu;
	}
	
	public static MenuScene getDefaultMenu() {
		return defaultMenu;
	}
}
