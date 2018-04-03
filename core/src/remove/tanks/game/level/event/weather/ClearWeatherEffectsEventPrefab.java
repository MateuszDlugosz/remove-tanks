package remove.tanks.game.level.event.weather;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class ClearWeatherEffectsEventPrefab extends EventPrefab {
    public static final ClearWeatherEffectsEventPrefab INSTANCE = new ClearWeatherEffectsEventPrefab();

    private ClearWeatherEffectsEventPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
