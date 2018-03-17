package remove.tanks.game.level.engine.system.world;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.system.EntitySystemPrefab;

/**
 * @author Mateusz Długosz
 */
public final class WorldUpdateSystemPrefab extends EntitySystemPrefab {
    public WorldUpdateSystemPrefab(int priority) {
        super(priority);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
