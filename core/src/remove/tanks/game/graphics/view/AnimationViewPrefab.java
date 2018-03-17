package remove.tanks.game.graphics.view;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphics.animation.AnimationPrefab;
import remove.tanks.game.utility.surface.position.PositionPrefab;

/**
 * @author Mateusz Długosz
 */
public final class AnimationViewPrefab extends ViewPrefab {
    private final String id;
    private final PositionPrefab positionPrefab;
    private final AnimationPrefab animationPrefab;

    public AnimationViewPrefab(String id, PositionPrefab positionPrefab, AnimationPrefab animationPrefab) {
        this.id = id;
        this.positionPrefab = positionPrefab;
        this.animationPrefab = animationPrefab;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public PositionPrefab getPositionPrefab() {
        return positionPrefab;
    }

    public AnimationPrefab getAnimationPrefab() {
        return animationPrefab;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("positionPrefab", positionPrefab)
                .add("animationPrefab", animationPrefab)
                .toString();
    }
}
