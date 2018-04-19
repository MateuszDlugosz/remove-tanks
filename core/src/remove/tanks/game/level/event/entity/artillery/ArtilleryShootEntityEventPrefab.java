package remove.tanks.game.level.event.entity.artillery;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EntityEventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class ArtilleryShootEntityEventPrefab extends EntityEventPrefab {
    public static final ArtilleryShootEntityEventPrefab INSTANCE = new ArtilleryShootEntityEventPrefab();

    private ArtilleryShootEntityEventPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
