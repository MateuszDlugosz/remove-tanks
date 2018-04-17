package remove.tanks.game.level.engine.system.weather;

import com.badlogic.ashley.core.EntitySystem;
import remove.tanks.game.level.utility.weather.Weather;
import remove.tanks.game.level.utility.weather.effect.WeatherEffect;

/**
 * @author Mateusz Długosz
 */
public final class WeatherSystem extends EntitySystem {
    private final Weather weather;

    public WeatherSystem(int priority, Weather weather) {
        super(priority);
        this.weather = weather;
    }

    public void addWeatherEffect(WeatherEffect effect) {
        weather.addWeatherEffect(effect);
    }

    public void removeWeatherEffect(String id) {
        weather.removeWeatherEffect(id);
    }

    public void clearWeatherEffects() {
        weather.clearWeatherEffects();
    }

    @Override
    public void update(float deltaTime) {
        weather.update(deltaTime);
    }
}
