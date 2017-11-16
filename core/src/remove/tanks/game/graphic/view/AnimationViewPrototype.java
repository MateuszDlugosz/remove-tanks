package remove.tanks.game.graphic.view;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphic.animation.AnimationPrototype;
import remove.tanks.game.utility.position.PositionPrototype;

/**
 * @author Mateusz Długosz
 */
public final class AnimationViewPrototype implements ViewPrototype {
    private final String id;
    private final PositionPrototype positionPrototype;
    private final AnimationPrototype animationPrototype;

    public AnimationViewPrototype(String id, PositionPrototype positionPrototype, AnimationPrototype animationPrototype) {
        this.id = id;
        this.positionPrototype = positionPrototype;
        this.animationPrototype = animationPrototype;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public PositionPrototype getPositionPrototype() {
        return positionPrototype;
    }

    public AnimationPrototype getAnimationPrototype() {
        return animationPrototype;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("positionPrototype", positionPrototype)
                .add("animationPrototype", animationPrototype)
                .toString();
    }
}
