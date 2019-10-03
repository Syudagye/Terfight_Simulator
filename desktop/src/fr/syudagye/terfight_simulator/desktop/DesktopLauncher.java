package fr.syudagye.terfight_simulator.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import fr.syudagye.terfight_simulator.Drop;
import fr.syudagye.terfight_simulator.GameManager;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Terfight Simulator";
		config.width = 1280;
		config.height = 720;
		GameManager gameManager = new GameManager();
		LwjglApplication app = new LwjglApplication(gameManager, config);
		gameManager.setGameManager(gameManager);
	}
}
