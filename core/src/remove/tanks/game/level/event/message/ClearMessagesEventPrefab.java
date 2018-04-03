package remove.tanks.game.level.event.message;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class ClearMessagesEventPrefab extends EventPrefab {
    public static final ClearMessagesEventPrefab INSTANCE = new ClearMessagesEventPrefab();

    private ClearMessagesEventPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
