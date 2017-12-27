package remove.tanks.game.level.engine.system.hud.stages.broker.face;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphic.sprite.SpritePrototype;

import java.io.Serializable;

/**
 * @author Mateusz Długosz
 */
public final class FacePrototype implements Serializable {
    private final String id;
    private final SpritePrototype spritePrototype;

    public FacePrototype(String id, SpritePrototype spritePrototype) {
        this.id = id;
        this.spritePrototype = spritePrototype;
    }

    public String getId() {
        return id;
    }

    public SpritePrototype getSpritePrototype() {
        return spritePrototype;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("spritePrototype", spritePrototype)
                .toString();
    }
}
