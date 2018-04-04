package remove.tanks.game.level.event.entity.life;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EntityEventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class RemoveLifeEntityEventPrefab extends EntityEventPrefab {
    public static final RemoveLifeEntityEventPrefab INSTANCE = new RemoveLifeEntityEventPrefab();

    private RemoveLifeEntityEventPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
