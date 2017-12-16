package remove.tanks.game.level.engine.system.environment;

import com.badlogic.ashley.core.EntitySystem;
import remove.tanks.game.level.engine.system.environment.weather.Weather;

/**
 * @author Mateusz Długosz
 */
public final class WeatherSystem extends EntitySystem {
    private final Weather weather;

    public WeatherSystem(int priority, Weather weather) {
        super(priority);
        this.weather = weather;
    }

    @Override
    public void update(float deltaTime) {
        weather.update(deltaTime);
    }
}