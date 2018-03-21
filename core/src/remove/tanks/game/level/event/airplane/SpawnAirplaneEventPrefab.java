package remove.tanks.game.level.event.airplane;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class SpawnAirplaneEventPrefab extends EventPrefab {
    public static final SpawnAirplaneEventPrefab INSTANCE = new SpawnAirplaneEventPrefab();

    private SpawnAirplaneEventPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
