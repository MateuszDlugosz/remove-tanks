package remove.tanks.game.level.engine.entity.component.faction;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class PlayerComponentPrefab extends ComponentPrefab {
    public static final PlayerComponentPrefab INSTANCE = new PlayerComponentPrefab();

    private PlayerComponentPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
