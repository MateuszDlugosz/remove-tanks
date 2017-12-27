package remove.tanks.game.level.engine.system.hud.stages.broker.face;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * @author Mateusz Długosz
 */
public final class Face {
    private final String id;
    private final Sprite sprite;

    public Face(String id, Sprite sprite) {
        this.id = id;
        this.sprite = sprite;
    }

    public String getId() {
        return id;
    }

    public Sprite getSprite() {
        return sprite;
    }
}
