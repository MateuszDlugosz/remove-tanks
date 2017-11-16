package remove.tanks.game.level.engine.system.respawn;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.system.EntitySystemPrototype;

/**
 * @author Mateusz Długosz
 */
public final class PlayerRespawnSystemPrototype extends EntitySystemPrototype {
    private final String prototypeCode;
    private final float respawnTime;

    public PlayerRespawnSystemPrototype(String prototypeCode, float respawnTime, int priority) {
        super(priority);
        this.prototypeCode = prototypeCode;
        this.respawnTime = respawnTime;
    }

    public String getPrototypeCode() {
        return prototypeCode;
    }

    public float getRespawnTime() {
        return respawnTime;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("prototypeCode", prototypeCode)
                .add("respawnTime", respawnTime)
                .toString();
    }
}
