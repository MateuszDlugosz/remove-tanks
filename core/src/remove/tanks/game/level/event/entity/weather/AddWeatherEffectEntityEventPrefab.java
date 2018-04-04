package remove.tanks.game.level.event.entity.weather;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EntityEventPrefab;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectPrefab;

/**
 * @author Mateusz Długosz
 */
public final class AddWeatherEffectEntityEventPrefab extends EntityEventPrefab {
    private final WeatherEffectPrefab weatherEffectPrefab;

    public AddWeatherEffectEntityEventPrefab(WeatherEffectPrefab weatherEffectPrefab) {
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
