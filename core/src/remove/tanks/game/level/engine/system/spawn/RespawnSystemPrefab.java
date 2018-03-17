package remove.tanks.game.level.engine.system.spawn;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.system.EntitySystemPrefab;

/**
 * @author Mateusz Długosz
 */
public final class RespawnSystemPrefab extends EntitySystemPrefab {
    private final String entityPrefabCode;
    private final float respawnTime;

    public RespawnSystemPrefab(int priority, String entityPrefabCode, float respawnTime) {
        super(priority);
        this.entityPrefabCode = entityPrefabCode;
        this.respawnTime = respawnTime;
    }

    public String getEntityPrefabCode() {
        return entityPrefabCode;
    }

    public float getRespawnTime() {
        return respawnTime;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("entityPrefabCode", entityPrefabCode)
                .add("respawnTime", respawnTime)
                .toString();
    }
}
