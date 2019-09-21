package fr.syudagye.terfight_simulator.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import fr.syudagye.terfight_simulator.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Terfight Simulator";
		config.width = 1280;
		config.height = 720;
		new LwjglApplication(new Main(config), config);
	}
}
