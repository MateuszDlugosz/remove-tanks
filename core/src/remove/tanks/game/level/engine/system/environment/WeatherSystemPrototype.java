package remove.tanks.game.level.engine.system.environment;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.system.EntitySystemPrototype;
import remove.tanks.game.level.engine.system.environment.weather.WeatherPrototype;

/**
 * @author Mateusz Długosz
 */
public final class WeatherSystemPrototype extends EntitySystemPrototype {
    private final WeatherPrototype weatherPrototype;

    public WeatherSystemPrototype(int priority, WeatherPrototype weatherPrototype) {
        super(priority);
        this.weatherPrototype = weatherPrototype;
    }

    public WeatherPrototype getWeatherPrototype() {
        return weatherPrototype;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("weatherPrototype", weatherPrototype)
                .toString();
    }
}
