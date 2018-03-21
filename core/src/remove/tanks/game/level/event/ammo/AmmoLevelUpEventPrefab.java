package remove.tanks.game.level.event.ammo;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class AmmoLevelUpEventPrefab extends EventPrefab {
    public static final AmmoLevelUpEventPrefab INSTANCE = new AmmoLevelUpEventPrefab();

    private AmmoLevelUpEventPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
