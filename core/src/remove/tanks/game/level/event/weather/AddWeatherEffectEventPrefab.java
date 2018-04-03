package remove.tanks.game.level.event.weather;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EventPrefab;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectPrefab;

/**
 * @author Mateusz Długosz
 */
public final class AddWeatherEffectEventPrefab extends EventPrefab {
    private final WeatherEffectPrefab weatherEffectPrefab;

    public AddWeatherEffectEventPrefab(WeatherEffectPrefab weatherEffectPrefab) {
        this.weatherEffectPrefab = weatherEffectPrefab;
    }

    public WeatherEffectPrefab getWeatherEffectPrefab() {
        return weatherEffectPrefab;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("weatherEffectPrefab", weatherEffectPrefab)
                .toString();
    }
}
