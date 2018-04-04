package remove.tanks.game.level.event.entity.message;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EntityEventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class ClearMessagesEntityEventPrefab extends EntityEventPrefab {
    public static final ClearMessagesEntityEventPrefab INSTANCE = new ClearMessagesEntityEventPrefab();

    private ClearMessagesEntityEventPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
