package remove.tanks.game.graphic.view;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphic.sprite.SpritePrototype;
import remove.tanks.game.utility.position.PositionPrototype;

/**
 * @author Mateusz Długosz
 */
public final class SpriteViewPrototype implements ViewPrototype {
    private final String id;
    private final PositionPrototype positionPrototype;
    private final SpritePrototype spritePrototype;

    public SpriteViewPrototype(String id, PositionPrototype positionPrototype, SpritePrototype spritePrototype) {
        this.id = id;
        this.positionPrototype = positionPrototype;
        this.spritePrototype = spritePrototype;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public PositionPrototype getPositionPrototype() {
        return positionPrototype;
    }

    public SpritePrototype getSpritePrototype() {
        return spritePrototype;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("positionPrototype", positionPrototype)
                .add("spritePrototype", spritePrototype)
                .toString();
    }
}
