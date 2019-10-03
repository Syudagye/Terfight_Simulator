package fr.syudagye.terfight_simulator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;

import java.util.ArrayList;

public class Player {

    private final float ANIMATION_COOLDOWN = 0.1f;
    private Texture texture_standing, texture_walking1, texture_walking2;
    private PlayerState playerState;
    private Timer timer;
    private int currentWalkAnim = 1;
    private int pos_x = 0, pos_y = 0;

    public Player(){
        playerState = PlayerState.STANDING;
        texture_standing = new Texture(Gdx.files.internal("textures/boloss.png"));
        texture_walking1 = new Texture(Gdx.files.internal("textures/boloss_walk1.png"));
        texture_walking2 = new Texture(Gdx.files.internal("textures/boloss_walk2.png"));
        timer = new Timer();
        Timer.Task task = new Timer.Task() {
            @Override
            public void run() {
                if(currentWalkAnim == 1) currentWalkAnim = 2;
                else if(currentWalkAnim == 2) currentWalkAnim = 1;
            }
        };
        timer.scheduleTask(task, 0, ANIMATION_COOLDOWN, -1);
    }

    public void render(GameManager gameManager, SpriteBatch batch){
        System.out.println(currentWalkAnim);
        if(gameManager.getGame_states() == GameStates.PLAYING){
            if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
                playerState = PlayerState.WALKING;
                pos_x++;
                if(currentWalkAnim == 1){
                    batch.draw(texture_walking1, pos_x, pos_y);
                }else if(currentWalkAnim == 2){
                    batch.draw(texture_walking2, pos_x, pos_y);
                }
            }else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                playerState = PlayerState.WALKING;
                pos_x--;
                if(currentWalkAnim == 1){
                    batch.draw(texture_walking1, pos_x, pos_y);
                }else if(currentWalkAnim == 2){
                    batch.draw(texture_walking2, pos_x, pos_y);
                }
            }else {
                playerState = PlayerState.STANDING;
                batch.draw(texture_standing, pos_x, pos_y);
            }
        }
    }

    private enum PlayerState{
        STANDING,
        WALKING,
        JUMPING
    }
}
