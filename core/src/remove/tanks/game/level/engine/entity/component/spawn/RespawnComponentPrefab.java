package remove.tanks.game.level.engine.entity.component.spawn;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class RespawnComponentPrefab extends ComponentPrefab {
    public static final RespawnComponentPrefab INSTANCE = new RespawnComponentPrefab();

    private RespawnComponentPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
