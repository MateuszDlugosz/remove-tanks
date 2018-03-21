package remove.tanks.game.level.event.life;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class RemoveLifeEventPrefab extends EventPrefab {
    public static final RemoveLifeEventPrefab INSTANCE = new RemoveLifeEventPrefab();

    private RemoveLifeEventPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
