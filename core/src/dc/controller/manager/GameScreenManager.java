package dc.controller.manager;

import java.util.HashMap;

import dc.game.DarkCave;
import dc.view.AboutScreen;
import dc.view.AbstractScreen;
import dc.view.CombatScreen;
import dc.view.GameOverScreen;
import dc.view.MainMenuScreen;
import dc.view.SettingsScreen;
import dc.view.StartScreen;
import dc.view.TransitionBattleScreen;
import dc.view.TransitionScreen;
import dc.view.VictoryScreen;
import dc.view.level.CaveLevelScreen;
import dc.view.level.FinaleLevelScreen;
import dc.view.level.FireLevelScreen;
import dc.view.level.HubLevelScreen;
import dc.view.level.WaterLevelScreen;

public class GameScreenManager {
	
	public DarkCave game;
	
	public HashMap<STATE, AbstractScreen> gameScreens; //HashMap degli screen
	
	public enum STATE {
		START,
		MAIN_MENU,
		SETTINGS,
		ABOUT,
		COMBAT,
		TRANSITION,
		HUB,
		CAVE,
		FIRELEVEL,
		WATERLEVEL,
		FINALE,
		VICTORY,
		GAMEOVER;
	}
	
	private STATE currScreen;
	
	public GameScreenManager(DarkCave game) {
		this.game = game;
		initGameScreens();
		setScreen(STATE.START);
	}
	
	private void initGameScreens() {
		this.gameScreens = new HashMap<STATE, AbstractScreen>();
		this.gameScreens.put(STATE.MAIN_MENU, new MainMenuScreen(game));
		this.gameScreens.put(STATE.SETTINGS, new SettingsScreen(game));
		this.gameScreens.put(STATE.START, new StartScreen(game));
		this.gameScreens.put(STATE.ABOUT, new AboutScreen(game));
		this.gameScreens.put(STATE.COMBAT, new CombatScreen(game));
		this.gameScreens.put(STATE.HUB, new HubLevelScreen(game));
		this.gameScreens.put(STATE.CAVE, new CaveLevelScreen(game));
		this.gameScreens.put(STATE.FIRELEVEL, new FireLevelScreen(game));
		this.gameScreens.put(STATE.WATERLEVEL, new WaterLevelScreen(game));
		this.gameScreens.put(STATE.FINALE, new FinaleLevelScreen(game));
		this.gameScreens.put(STATE.VICTORY, new VictoryScreen(game));
		this.gameScreens.put(STATE.GAMEOVER, new GameOverScreen(game));
	}
	
	public void setScreen(STATE nextScreen) {
		game.setScreen(gameScreens.get(nextScreen));
	}
	
	public void doTransition(STATE next) {
		game.setScreen(new TransitionScreen(currScreen, next, game));
	}
	
	public void doTransitionBattle(STATE next) {
		game.setScreen(new TransitionBattleScreen(currScreen, next, game));
	}
	
	public void setCurrScreen(STATE currScreen) {
		this.currScreen = currScreen;
	}
	
	public AbstractScreen getScreen(STATE screen) {
		return gameScreens.get(screen);
	}
	
	public STATE getPrevState() {
		return currScreen;
	}
	
	public AbstractScreen getPrevScreen() {
		return gameScreens.get(currScreen);
	}
	
	public void dispose() { 
		for(AbstractScreen screen : gameScreens.values()) {
			if (screen != null) {
				screen.dispose();
			}
		}
	}
}



/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\controller\manager\GameScreenManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */