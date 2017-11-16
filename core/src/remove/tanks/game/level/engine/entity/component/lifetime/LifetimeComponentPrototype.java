package remove.tanks.game.level.engine.entity.component.lifetime;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;

/**
 * @author Mateusz Długosz
 */
public final class LifetimeComponentPrototype implements ComponentPrototype {
    private final float lifetime;

    public LifetimeComponentPrototype(float lifetime) {
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
