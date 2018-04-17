package remove.tanks.game.physics.fixture;

import com.google.common.base.MoreObjects;
import remove.tanks.game.physics.filter.FilterPrefab;
import remove.tanks.game.physics.shape.ShapePrefab;
import remove.tanks.game.utility.Prefab;

/**
 * @author Mateusz Długosz
 */
public final class FixturePrefab extends Prefab {
    private final FilterPrefab filterPrefab;
    private final ShapePrefab shapePrefab;
    private final float restitution;
    private final float density;
    private final float friction;

    public FixturePrefab(
            FilterPrefab filterPrefab,
            ShapePrefab shapePrefab,
            float restitution,
            float density,
            float friction
    ) {
        this.filterPrefab = filterPrefab;
        this.shapePrefab = shapePrefab;
        this.restitution = restitution;
        this.density = density;
        this.friction = friction;
    }

    public FilterPrefab getFilterPrefab() {
        return filterPrefab;
    }

    public ShapePrefab getShapePrefab() {
        return shapePrefab;
    }

    public float getRestitution() {
        return restitution;
    }

    public float getDensity() {
        return density;
    }

    public float getFriction() {
        return friction;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("filterPrefab", filterPrefab)
                .add("shapePrefab", shapePrefab)
                .add("restitution", restitution)
                .add("density", density)
                .add("friction", friction)
                .toString();
    }
}