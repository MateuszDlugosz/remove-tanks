package remove.tanks.game.physics.light;

import com.google.common.base.MoreObjects;
import remove.tanks.game.utility.Prefab;

/**
 * @author Mateusz Długosz
 */
public final class LightHandlerPrefab extends Prefab {
    private final String id;
    private final LightPrefab lightPrefab;

    public LightHandlerPrefab(String id, LightPrefab lightPrefab) {
        this.id = id;
        this.lightPrefab = lightPrefab;
    }

    public String getId() {
        return id;
    }

    public LightPrefab getLightPrefab() {
        return lightPrefab;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("lightPrefab", lightPrefab)
                .toString();
    }
}
