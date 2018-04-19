package remove.tanks.game.level.event.artillery;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class ArtilleryShootEventPrefab extends EventPrefab {
    public static final ArtilleryShootEventPrefab INSTANCE = new ArtilleryShootEventPrefab();

    private ArtilleryShootEventPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
