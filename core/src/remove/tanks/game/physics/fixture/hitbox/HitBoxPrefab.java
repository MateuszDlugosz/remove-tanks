package remove.tanks.game.physics.fixture.hitbox;

import com.google.common.base.MoreObjects;
import remove.tanks.game.physics.fixture.FixturePrefab;
import remove.tanks.game.utility.Prefab;

/**
 * @author Mateusz Długosz
 */
public final class HitBoxPrefab extends Prefab {
    private final String id;
    private final FixturePrefab fixturePrefab;

    public HitBoxPrefab(String id, FixturePrefab fixturePrefab) {
        this.id = id;
        this.fixturePrefab = fixturePrefab;
    }

    public String getId() {
        return id;
    }

    public FixturePrefab getFixturePrefab() {
        return fixturePrefab;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("fixturePrefab", fixturePrefab)
                .toString();
    }
}
