package fr.syudagye.terfight_simulator;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GameObject {

    private SpriteBatch batch = new SpriteBatch();

    private Texture image;
    private int pos_x, pos_y;
    private boolean dead = false;

    public GameObject(Texture image, int pos_x, int pos_y){
        this.image = image;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
    }

    public abstract void render();

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public Texture getImage() {
        return image;
    }

    public void setImage(Texture image) {
        this.image = image;
    }

    public int getPos_x() {
        return pos_x;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }
}
