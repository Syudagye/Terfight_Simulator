package fr.syudagye.terfight_simulator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import fr.syudagye.terfight_simulator.assets.Terfight;

import java.util.ArrayList;

public class Main extends ApplicationAdapter {
	private GameStates game_states;
	private LwjglApplicationConfiguration app_config;

	public static ArrayList<GameObject> game_objects = new ArrayList<>();

	public Main(LwjglApplicationConfiguration app_config){
		this.app_config = app_config;
	}

	@Override
	public void create () {
		new Terfight(new Texture(Gdx.files.internal("terfight.png")), 0, 0);
		game_states = GameStates.INTRO;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		for(int i = 0; i < game_objects.size(); i++){
			GameObject obj = game_objects.get(i);
			if (obj.isDead()){
				game_objects.remove(i);
				i--;
				break;
			}
			obj.render();
		}
	}
	
	@Override
	public void dispose () {
	}


	public GameStates getGame_states() {
		return game_states;
	}

	public void setGame_states(GameStates game_states) {
		this.game_states = game_states;
	}
}
