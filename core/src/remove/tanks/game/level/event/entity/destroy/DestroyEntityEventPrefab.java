package remove.tanks.game.level.event.entity.destroy;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EntityEventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class DestroyEntityEventPrefab extends EntityEventPrefab {
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
