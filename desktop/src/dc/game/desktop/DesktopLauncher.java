package dc.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import dc.game.DarkCave;
import dc.settings.Constans;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = Constans.APP_TITLE;
		config.x = 250;
		config.y = 40;
		config.width = Constans.APP_DESKTOP_WIDTH;
		config.height = Constans.APP_DESKTOP_HEIGHT;
		config.resizable = false;
		config.fullscreen=true;
		new LwjglApplication(new DarkCave(), config);
	}
}
