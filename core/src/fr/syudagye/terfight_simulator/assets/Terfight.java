package fr.syudagye.terfight_simulator.assets;

import com.badlogic.gdx.graphics.Texture;
import fr.syudagye.terfight_simulator.GameObject;
import fr.syudagye.terfight_simulator.Main;

public class Terfight extends GameObject {

    public Terfight(Texture image, int pos_x, int pos_y) {
        super(image, pos_x, pos_y);
        Main.game_objects.add(this);
    }

    @Override
    public void render() {
        getBatch().begin();
        getBatch().draw(getImage(), getPos_x(), getPos_y());
        getBatch().end();
    }
}
