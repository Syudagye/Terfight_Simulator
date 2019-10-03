package fr.syudagye.terfight_simulator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameManager extends ApplicationAdapter {
	private GameStates game_states;
	private static SpriteBatch batch;
	private GameManager gameManager;
	private OrthographicCamera camera;

	private Player player;

	@Override
	public void create () {
		game_states = GameStates.PLAYING;
		batch = new SpriteBatch();
		player = new Player();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 100, 50);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		player.render(gameManager, batch);

		batch.end();
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

	public GameManager getGameManager() {
		return gameManager;
	}

	public void setGameManager(GameManager gameManager) {
		this.gameManager = gameManager;
	}
}
