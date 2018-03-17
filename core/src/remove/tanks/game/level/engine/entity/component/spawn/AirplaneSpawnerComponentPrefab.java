package remove.tanks.game.level.engine.entity.component.spawn;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class AirplaneSpawnerComponentPrefab extends ComponentPrefab {
    private final String entityPrefabCode;

    public AirplaneSpawnerComponentPrefab(String entityPrefabCode) {
        this.entityPrefabCode = entityPrefabCode;
    }

    public String getEntityPrefabCode() {
        return entityPrefabCode;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("entityPrefabCode", entityPrefabCode)
                .toString();
    }
}
