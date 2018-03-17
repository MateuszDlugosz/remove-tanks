package remove.tanks.game.level.engine.entity.component.lifecycle;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class LifetimeComponentPrefab extends ComponentPrefab {
    private final float lifetime;

    public LifetimeComponentPrefab(float lifetime) {
        this.lifetime = lifetime;
    }

    public float getLifetime() {
        return lifetime;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("lifetime", lifetime)
                .toString();
    }
}
