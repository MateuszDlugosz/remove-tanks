package remove.tanks.game.level.engine.system.weather;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.system.EntitySystemPrefab;
import remove.tanks.game.level.utility.weather.WeatherPrefab;

/**
 * @author Mateusz Długosz
 */
public final class WeatherSystemPrefab extends EntitySystemPrefab {
    private final WeatherPrefab weatherPrefab;

    public WeatherSystemPrefab(int priority, WeatherPrefab weatherPrefab) {
        super(priority);
        this.weatherPrefab = weatherPrefab;
    }

    public WeatherPrefab getWeatherPrefab() {
        return weatherPrefab;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("weatherPrefab", weatherPrefab)
                .toString();
    }
}
